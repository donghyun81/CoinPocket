package com.example.coinpocket.di

import android.content.Context
import androidx.room.Room
import com.example.coinpocket.data.local.CoinPocketDatabase
import com.example.coinpocket.data.local.ImageTypeConverter
import com.example.coinpocket.data.local.StockDao
import com.example.coinpocket.data.local.StockRemoteKeysDao
import com.example.coinpocket.data.repository.dataSource.CompanyLocalDataSource
import com.example.coinpocket.data.repository.dataSourceImpl.CompanyLocalDataSourceImpl
import com.example.coinpocket.data.repository.dataSourceImpl.CompanyRemoteDataSourceImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
    fun provideStockDao(coinPocketDatabase: CoinPocketDatabase) : StockDao= coinPocketDatabase.stockDao()

    @Provides
    @Singleton
    fun provideStockRemoteKeysDao(coinPocketDatabase: CoinPocketDatabase) : StockRemoteKeysDao = coinPocketDatabase.stockRemoteKeys()


    @Provides
    @Singleton
    fun provideLocalDataSource(stockDao: StockDao): CompanyLocalDataSource =
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