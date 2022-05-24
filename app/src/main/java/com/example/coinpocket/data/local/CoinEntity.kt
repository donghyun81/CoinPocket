package com.example.coinpocket.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Month
import java.time.MonthDay

@Entity
data class CoinEntity(
    @PrimaryKey val id: Int? = null,
    val money:String,
    val day: String
)

class InvalidCoinException(message: String): Exception(message)
