package com.example.coinpocket.di

import android.app.Application
import androidx.room.Room
import com.example.coinpocket.data.local.CoinPocketDatabase
import com.example.coinpocket.data.remote.StockApi
import com.example.coinpocket.data.repository.CoinRepositoryImpl
import com.example.coinpocket.domain.repository.CoinRepository
import com.example.coinpocket.domain.use_case.AddCoin
import com.example.coinpocket.domain.use_case.CoinUseCases
import com.example.coinpocket.domain.use_case.GetCoin
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideStockApi():StockApi {
        return Retrofit.Builder()
            .baseUrl(StockApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()

    }

    @Provides
    @Singleton
    fun provideStockDatabase(app: Application):CoinPocketDatabase {
        return Room.databaseBuilder(
            app,
            CoinPocketDatabase::class.java,
            "stockdb.db",
        ).build()
    }

    @Provides
    @Singleton
    fun provideCoinRepository(db:CoinPocketDatabase): CoinRepository {
        return CoinRepositoryImpl(db.coinDao)
    }

    @Provides
    @Singleton
    fun provideCoinUseCases(repository: CoinRepository):CoinUseCases{
        return CoinUseCases(
            getCoin = GetCoin(repository = repository),
            addCoin = AddCoin(repository = repository)
        )
    }

}