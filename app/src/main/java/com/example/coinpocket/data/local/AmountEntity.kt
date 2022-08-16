package com.example.coinpocket.data.local

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.*
import com.example.coinpocket.domain.model.IconSample
import com.google.gson.Gson
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable


@Entity
data class AmountEntity(
    @PrimaryKey val id: Int? = null,
    val title:String,
    val isDeposit:Boolean,
    val day: String,
    @DrawableRes val imageUrl: Int,
    val content:String,
    val amount:Int
)

class InvalidAmountException(message: String): Exception(message)
