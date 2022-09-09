package com.example.coinpocket.data.remote

import com.example.coinpocket.domain.model.CompanyListing
import com.example.coinpocket.domain.model.CompanyListingEntity
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET("getStockPriceInfo")
    suspend fun getListings(
        @Query("serviceKey") serviceKey:String = API_KEY,
        @Query("pageNo") pageNo:Int = 1,
        @Query("resultType") stockType:String = resultType
    ): Response<CompanyListing>

    companion object {
        const val API_KEY ="7YYm9zqmvt6gd9ldV14wCSSvqLMA/vdK64I+zNI5ax0lHFbxQk71tEiFsCSJh60IKkTbY7Mi1Q5Q6nWcUWrt+A=="
        const val resultType = "json"
        const val BASE_URL ="http://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/"
    }
}