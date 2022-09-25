package com.example.coinpocket.data.remote

import com.example.coinpocket.BuildConfig
import com.example.coinpocket.domain.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/")
    fun search(
        @Query("q") searchString: String,
        @Query("key") apiKey: String = BuildConfig.API_KEYY
    ) : Call<SearchResponse>
}