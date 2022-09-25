package com.example.coinpocket.domain.model

import com.google.gson.annotations.SerializedName


data class CompanyListing(
    @SerializedName("header")
    val header: Header,
    @SerializedName("body")
    val companies:Body,
){
    data class Header(
        val resultCode: Int,
        val resultMsg: String
    )

    data class Body(
        @SerializedName("pageNo")
        val pageNo:Int,
        val items: Items
    )

    data class Items(
        @SerializedName("items")
        val item: List<CompanyListingEntity>
    )

}

