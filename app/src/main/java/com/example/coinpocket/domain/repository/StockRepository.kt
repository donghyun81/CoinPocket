package com.example.coinpocket.domain.repository

import com.example.coinpocket.domain.model.CompanyListing
import com.example.coinpocket.domain.model.IntradayInfo
import com.example.coinpocket.presentation.company_info.CompanyInfo
import com.example.coinpocket.util.Resource
import kotlinx.coroutines.flow.Flow


interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote:Boolean,
        query:String
    ):Flow<Resource<List<CompanyListing>>>


    suspend fun getIntradayInfo(
        symbol:String
    ):Resource<List<IntradayInfo>>

    suspend fun getCompanyInfo(
        symbol: String
    ):Resource<CompanyInfo>

}