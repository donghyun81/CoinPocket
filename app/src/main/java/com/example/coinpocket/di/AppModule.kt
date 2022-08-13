package com.example.coinpocket.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.coinpocket.data.local.CoinPocketDatabase
import com.example.coinpocket.data.local.ImageVectorTypeConverter
import com.example.coinpocket.data.remote.StockApi
import com.example.coinpocket.data.repository.AmountRepositoryImpl
import com.example.coinpocket.domain.repository.AmountRepository
import com.example.coinpocket.domain.use_case.*
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideMoshi(): Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

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
    fun provideStockDatabase(
        @ApplicationContext context: Context,
        imageVectorTypeConverter: ImageVectorTypeConverter
        ):CoinPocketDatabase {
        return Room
            .databaseBuilder(
            context,
            CoinPocketDatabase::class.java,
            "stockdb.db",
        )
            .fallbackToDestructiveMigration()
            .addTypeConverter(imageVectorTypeConverter)
            .build()
    }

    @Provides
    @Singleton
    fun provideImageVectorTypeConverter(moshi: Moshi): ImageVectorTypeConverter = ImageVectorTypeConverter(moshi)

    @Provides
    @Singleton
    fun provideCoinRepository(db:CoinPocketDatabase): AmountRepository {
        return AmountRepositoryImpl(db.amountDao)
    }

    @Provides
    @Singleton
    fun provideCoinUseCases(repository: AmountRepository):AmountUseCases{
        return AmountUseCases(
            getCoin = GetAmount(repository = repository),
            addAmount = AddAmount(repository = repository),
            getDayAccounts = GetDayAccounts(repository=repository),
            deleteAmount = DeleteAmount(repository),
            updateAmount = UpdateAmount(repository)
        )
    }

    @Provides
    @Singleton
    fun provideFilterOutDigitsUseCase(): FilterOutDigits {
        return FilterOutDigits()
    }

}