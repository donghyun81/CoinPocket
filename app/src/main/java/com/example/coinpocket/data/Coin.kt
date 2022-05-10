package com.example.coinpocket.data

import androidx.room.Entity
import java.time.Month

@Entity
data class Coin(
    val money:String,
    val percent:Float,
    val dayofMonth: Month
)
