package com.example.coinpocket.di


import com.example.coinpocket.data.local.CoinPocketDatabase
import com.example.coinpocket.data.repository.AmountRepositoryImpl
import com.example.coinpocket.data.repository.CompanyRepositoryImpl
import com.example.coinpocket.data.repository.dataSource.CompanyLocalDataSource
import com.example.coinpocket.data.repository.dataSource.CompanyRemoteDataSource
import com.example.coinpocket.domain.repository.AmountRepository
import com.example.coinpocket.domain.repository.StockRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCoinRepository(db: CoinPocketDatabase): AmountRepository {
        return AmountRepositoryImpl(db.amountDao)
    }


    @Provides
    @Singleton
    fun provideStockRepository(
        companyRemoteDataSource: CompanyRemoteDataSource,
        companyLocalDataSource: CompanyLocalDataSource
    ): StockRepository =
        CompanyRepositoryImpl(companyRemoteDataSource, companyLocalDataSource)
}