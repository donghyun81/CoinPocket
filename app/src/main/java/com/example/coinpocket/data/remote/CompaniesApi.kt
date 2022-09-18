package com.example.coinpocket.data.remote

import com.example.coinpocket.BuildConfig
import com.example.coinpocket.domain.model.CompanyListing
import com.example.coinpocket.domain.model.CompanyListingEntity
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CompaniesApi {

    @GET("getStockPriceInfo")
    suspend fun getListings(
        @Query("serviceKey") serviceKey:String = API_KEY,
        @Query("pageNo") pageNo:Int = 1,
        @Query("resultType") stockType:String = resultType
    ): Response<CompanyListing>

    companion object {
        const val API_KEY = BuildConfig.API_KEY
        const val resultType = "json"
        const val BASE_URL = BuildConfig.BASE_URL
    }
}