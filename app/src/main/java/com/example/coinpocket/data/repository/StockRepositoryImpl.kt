package com.example.coinpocket.data.repository

import androidx.paging.PagingData
import com.example.coinpocket.data.repository.dataSource.CompanyLocalDataSource
import com.example.coinpocket.data.repository.dataSource.CompanyRemoteDataSource
import com.example.coinpocket.domain.repository.StockRepository
import com.example.coinpocket.domain.model.CompanyListingEntity
import kotlinx.coroutines.flow.Flow


class StockRepositoryImpl(
    private val companyRemoteDataSource: CompanyRemoteDataSource,
    private val companyLocalDataSource: CompanyLocalDataSource,
) : StockRepository{

    override fun getCompanise(): Flow<PagingData<CompanyListingEntity>> =
        companyRemoteDataSource.getCompanies()

    override fun getCompanyFromDB(id: Int): Flow<CompanyListingEntity> =
        companyLocalDataSource.getCompaniesFromDB(id)

}