package com.example.coinpocket.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
 data class CompanyListingEntity(
   @SerializedName("mrktTotAmt")
    val mrktTotAmt:Int,
   @SerializedName("basDt")
    val basDt:String,
   @SerializedName("itmsNm")
    val itmsNm :String,
    @PrimaryKey(autoGenerate = true)
    val id:Int
 )


