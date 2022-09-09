package com.example.coinpocket.data.repository.dataSource

import androidx.paging.PagingData
import com.example.coinpocket.domain.model.CompanyListingEntity
import kotlinx.coroutines.flow.Flow

interface CompanyRemoteDataSource {
    fun getCompanies(): Flow<PagingData<CompanyListingEntity>>
}