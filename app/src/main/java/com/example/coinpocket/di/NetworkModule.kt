package com.example.coinpocket.di

import com.example.coinpocket.data.local.CoinPocketDatabase
import com.example.coinpocket.data.remote.StockApi
import com.example.coinpocket.data.repository.dataSource.CompanyRemoteDataSource
import com.example.coinpocket.data.repository.dataSourceImpl.CompanyRemoteDataSourceImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Singleton
    fun provideCompanyRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(StockApi.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideStockApi(retrofit: Retrofit): StockApi {
        return retrofit.create(StockApi::class.java)
    }

    @Provides
    @Singleton
    fun provideStockRemoteDataSource(stockApi: StockApi, coinPocketDatabase: CoinPocketDatabase) : CompanyRemoteDataSource =
        CompanyRemoteDataSourceImpl(stockApi,coinPocketDatabase)

}