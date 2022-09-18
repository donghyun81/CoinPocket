package com.example.coinpocket.data.repository.dataSourceImpl

import com.example.coinpocket.data.local.CompaniesDao
import com.example.coinpocket.data.repository.dataSource.CompanyLocalDataSource
import com.example.coinpocket.domain.model.CompanyListingEntity
import kotlinx.coroutines.flow.Flow

class CompanyLocalDataSourceImpl(private val stockDao: CompaniesDao):CompanyLocalDataSource {
    override fun getCompaniesFromDB(id: Int): Flow<CompanyListingEntity>
    =stockDao.getCompany(id)
}