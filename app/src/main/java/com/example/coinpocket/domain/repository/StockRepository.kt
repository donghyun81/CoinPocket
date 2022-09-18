package com.example.coinpocket.domain.repository

import androidx.paging.PagingData
import com.example.coinpocket.domain.model.CompanyListingEntity
import kotlinx.coroutines.flow.Flow


interface StockRepository {
    fun getCompanise(): Flow<PagingData<CompanyListingEntity>>
    fun getCompanyFromDB(id: Int): Flow<CompanyListingEntity>
}