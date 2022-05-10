package com.example.coinpocket.di

import com.example.coinpocket.data.csv.CSVParser
import com.example.coinpocket.data.csv.CompanyListingsParser
import com.example.coinpocket.data.csv.IntradayInfoParser
import com.example.coinpocket.data.repository.StockRepositoryImpl
import com.example.coinpocket.domain.model.CompanyListing
import com.example.coinpocket.domain.model.IntradayInfo
import com.example.coinpocket.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingParser(
        companyListingsParser:CompanyListingsParser
    ):CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfoParser
    ):CSVParser<IntradayInfo>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ):StockRepository
}