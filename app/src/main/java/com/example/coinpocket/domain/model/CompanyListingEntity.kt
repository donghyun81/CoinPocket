package com.example.coinpocket.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity
 data class CompanyListingEntity(
    val mrktTotAmt:Int,
    val basDt:String,
    val itmsNm :String,
    @PrimaryKey(autoGenerate = true)
    val id:Int
 )


