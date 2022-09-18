package com.example.coinpocket.di

import com.example.coinpocket.data.local.CoinPocketDatabase
import com.example.coinpocket.data.remote.CompaniesApi
import com.example.coinpocket.data.repository.dataSource.CompanyRemoteDataSource
import com.example.coinpocket.data.repository.dataSourceImpl.CompanyRemoteDataSourceImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

//    @Provides
//    @Singleton
//    fun provideCompanyRetrofit(
//        okHttpClient: OkHttpClient,
//    ): Retrofit {
//
//        val gson: Gson = GsonBuilder()
//            .setLenient()
//            .create()
//
//        return Retrofit.Builder()
//            .baseUrl(CompaniesApi.BASE_URL)
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//    }

    //kotlinx.serialization 예시
    @Provides
    @Singleton
    fun provideCompanyRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(CompaniesApi.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideStockApi(retrofit: Retrofit): CompaniesApi {
        return retrofit.create(CompaniesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideStockRemoteDataSource(stockApi: CompaniesApi, coinPocketDatabase: CoinPocketDatabase) : CompanyRemoteDataSource =
        CompanyRemoteDataSourceImpl(stockApi,coinPocketDatabase)

}