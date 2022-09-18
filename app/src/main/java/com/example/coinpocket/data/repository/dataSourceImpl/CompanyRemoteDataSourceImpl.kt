package com.example.coinpocket.data.repository.dataSourceImpl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.coinpocket.data.local.CoinPocketDatabase
import com.example.coinpocket.data.paging.CompanyRemoteMediator
import com.example.coinpocket.data.remote.CompaniesApi
import com.example.coinpocket.data.repository.dataSource.CompanyRemoteDataSource
import com.example.coinpocket.domain.model.CompanyListingEntity
import kotlinx.coroutines.flow.Flow

class CompanyRemoteDataSourceImpl(private val stockApi: CompaniesApi, private val coinPocketDatabase: CoinPocketDatabase)
    :CompanyRemoteDataSource {
    private val stockDao = coinPocketDatabase.stockDao()

    @OptIn(ExperimentalPagingApi::class)
    override fun getCompanies(): Flow<PagingData<CompanyListingEntity>> {
        val pagingSourceFactory = { stockDao.getAllCompany() }
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = CompanyRemoteMediator(
                stockApi,
                coinPocketDatabase
            ),
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }
}