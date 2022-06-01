package com.example.coinpocket.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Month

@Entity
data class Coin(
    @PrimaryKey val id:Int,
    val money:String,
    val percent:Float,
    val dayofMonth: Month
)
