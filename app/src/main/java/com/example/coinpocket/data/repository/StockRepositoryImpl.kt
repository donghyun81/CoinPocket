package com.example.coinpocket.data.repository

import com.example.coinpocket.data.csv.CSVParser
import com.example.coinpocket.data.local.CoinPocketDatabase
import com.example.coinpocket.data.mapper.toCompanyInfo
import com.example.coinpocket.data.mapper.toCompanyListing
import com.example.coinpocket.data.mapper.toCompanyListingEntity
import com.example.coinpocket.data.remote.StockApi
import com.example.coinpocket.domain.model.CompanyListing
import com.example.coinpocket.domain.model.IntradayInfo
import com.example.coinpocket.domain.repository.StockRepository
import com.example.coinpocket.domain.model.CompanyInfo
import com.example.coinpocket.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    private val api:StockApi,
    private val db:CoinPocketDatabase,
    private val companyListingsParser: CSVParser<CompanyListing>,
    private val intradayInfoParser:CSVParser<IntradayInfo>
):StockRepository {

    private val dao = db.stockDao

    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.searchCompanyListings(query)
            emit(Resource.Succese(data = localListings.map { it.toCompanyListing() }))
            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote

            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }
            val remoteListings = try {
                val response = api.getListings()
                companyListingsParser.parse(response.byteStream())
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Could't load data"))
                null
            } catch (e: HttpException) {
                emit(Resource.Error("Could't load data"))
                null
            }
            remoteListings?.let { listings ->
                dao.clearCompanyListings()
                dao.insertCompanyListings(
                    listings.map { it.toCompanyListingEntity() }
                )
                emit(
                    Resource.Succese(
                       data= dao
                           .searchCompanyListings("")
                           .map { it.toCompanyListing() })
                )
                emit(Resource.Loading(false))
            }


        }
    }

    override suspend fun getIntradayInfo(symbol: String): Resource<List<IntradayInfo>> {
        return try {
            val response = api.getIntradayInfo(symbol = symbol)
            val results = intradayInfoParser.parse(response.byteStream())
            Resource.Succese(results)

        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Error(
                "Couldn't load intraday info"
            )
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error(
                "Couldn't load intraday info"
            )
        }
    }

        override suspend fun getCompanyInfo(symbol: String): Resource<CompanyInfo> {
            return try {
                val result = api.getCompanyInfo(symbol = symbol)
                Resource.Succese(result.toCompanyInfo())
            } catch (e: IOException) {
                e.printStackTrace()
                Resource.Error(
                    "Couldn't load company info"
                )
            } catch (e: HttpException) {
                e.printStackTrace()
                Resource.Error(
                    "Couldn't load company info"
                )
            }
        }

}