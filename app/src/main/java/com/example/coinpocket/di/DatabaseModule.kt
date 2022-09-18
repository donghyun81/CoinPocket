package com.example.coinpocket.di

import android.content.Context
import androidx.room.Room
import com.example.coinpocket.data.local.CoinPocketDatabase
import com.example.coinpocket.data.local.CompaniesDao
import com.example.coinpocket.data.local.CompaniesRemoteKeysDao
import com.example.coinpocket.data.repository.dataSource.CompanyLocalDataSource
import com.example.coinpocket.data.repository.dataSourceImpl.CompanyLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {




    @Provides
    @Singleton
    fun provideStockDao(coinPocketDatabase: CoinPocketDatabase) : CompaniesDao= coinPocketDatabase.stockDao()

    @Provides
    @Singleton
    fun provideStockRemoteKeysDao(coinPocketDatabase: CoinPocketDatabase) : CompaniesRemoteKeysDao = coinPocketDatabase.stockRemoteKeys()


    @Provides
    @Singleton
    fun provideLocalDataSource(stockDao: CompaniesDao): CompanyLocalDataSource =
        CompanyLocalDataSourceImpl(stockDao = stockDao)

    @Provides
    @Singleton
    fun provideStockDatabase(
        @ApplicationContext context: Context,
    ): CoinPocketDatabase {
        return Room
            .databaseBuilder(
                context,
                CoinPocketDatabase::class.java,
                "stockdb.db",
            )
            .fallbackToDestructiveMigration()
            .build()
    }


}