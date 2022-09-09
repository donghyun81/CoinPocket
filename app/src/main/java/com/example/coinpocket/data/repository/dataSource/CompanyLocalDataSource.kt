package com.example.coinpocket.data.repository.dataSource

import com.example.coinpocket.domain.model.CompanyListingEntity
import kotlinx.coroutines.flow.Flow

interface CompanyLocalDataSource {
    fun getCompaniesFromDB(id:Int): Flow<CompanyListingEntity>
}