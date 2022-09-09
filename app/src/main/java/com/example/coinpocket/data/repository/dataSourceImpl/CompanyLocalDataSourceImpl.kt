package com.example.coinpocket.data.repository.dataSourceImpl

import com.example.coinpocket.data.local.StockDao
import com.example.coinpocket.data.repository.dataSource.CompanyLocalDataSource
import com.example.coinpocket.domain.model.CompanyListingEntity
import kotlinx.coroutines.flow.Flow

class CompanyLocalDataSourceImpl(private val stockDao: StockDao):CompanyLocalDataSource {
    override fun getCompaniesFromDB(id: Int): Flow<CompanyListingEntity>
    =stockDao.getCompany(id)
}