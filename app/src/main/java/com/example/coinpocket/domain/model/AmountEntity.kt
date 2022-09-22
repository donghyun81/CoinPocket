package com.example.coinpocket.data.local

import androidx.room.*
import com.example.coinpocket.domain.model.CategoryImage

@Entity
data class AmountEntity(
    @PrimaryKey val id: Int? = null,
    val title:String,
    val isDeposit:Boolean,
    val day: String,
    val categoryImage:CategoryImage,
    val content:String,
    val amount:Long,
)
