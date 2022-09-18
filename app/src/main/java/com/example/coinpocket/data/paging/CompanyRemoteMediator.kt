package com.example.coinpocket.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.coinpocket.data.local.CoinPocketDatabase
import com.example.coinpocket.data.remote.CompaniesApi
import com.example.coinpocket.domain.model.CompanyListRemoteKeys
import com.example.coinpocket.domain.model.CompanyListingEntity
import javax.inject.Inject
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Singleton
class CompanyRemoteMediator @Inject constructor(
    private val stockApi:CompaniesApi,
    private val companyDb:CoinPocketDatabase
): RemoteMediator<Int, CompanyListingEntity>() {

    private val companyDao = companyDb.stockDao()
    private val companyListRemoteKeys = companyDb.stockRemoteKeys()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CompanyListingEntity>
    ): MediatorResult {
        return try {
            val page= when(loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1

                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage

                }
                LoadType.APPEND -> {

                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }
                    val response = stockApi.getListings(pageNo = page)
                    var endOfPaginationReached = false
                if (response.isSuccessful) {
                    val responseData = response.body()!!.companies
                    endOfPaginationReached = responseData == null
                    responseData?.let {
                        companyDb.withTransaction {
                            if (loadType == LoadType.REFRESH) {
                                companyDao.deleteAllCompany()
                                companyListRemoteKeys.deleteAllCompanyRemoteKeys()
                            }
                            var prevPage: Int?
                            var nextPage: Int

                            responseData.pageNo.let{ pageNumber ->
                                nextPage = pageNumber + 1
                                prevPage = if (pageNumber <= 1) null else pageNumber - 1
                            }

                            val keys = responseData.items.item.map { company ->
                                CompanyListRemoteKeys(
                                    id = company.id,
                                    prevPage = prevPage,
                                    nextPage = nextPage,
                                    lastUpdated = System.currentTimeMillis()
                                )
                            }
                            companyListRemoteKeys.addAllCompanyRemoteKeys(movieRemoteKeys = keys)
                            companyDao.addCompanies(companies = responseData.items.item)
                        }
                    }

                }
                MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
            }
        catch (e:Exception){
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, CompanyListingEntity>
    ): CompanyListRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                companyListRemoteKeys.getCompanyRemoteKeys(id = id)
            }
        }
    }


    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, CompanyListingEntity>,
    ): CompanyListRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { company ->
                companyListRemoteKeys.getCompanyRemoteKeys(id = company.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, CompanyListingEntity>,
    ): CompanyListRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { company ->
                companyListRemoteKeys.getCompanyRemoteKeys(id = company.id)
            }
    }
}