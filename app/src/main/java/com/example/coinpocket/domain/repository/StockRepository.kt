package com.example.coinpocket.domain.repository

import androidx.paging.PagingData
import com.example.coinpocket.domain.model.CompanyListing
import com.example.coinpocket.domain.model.IntradayInfo
import com.example.coinpocket.domain.model.CompanyInfo
import com.example.coinpocket.domain.model.CompanyListingEntity
import com.example.coinpocket.util.Resource
import kotlinx.coroutines.flow.Flow


interface StockRepository {
    fun getCompanise(): Flow<PagingData<CompanyListingEntity>>
    fun getCompanyFromDB(id: Int): Flow<CompanyListingEntity>
}