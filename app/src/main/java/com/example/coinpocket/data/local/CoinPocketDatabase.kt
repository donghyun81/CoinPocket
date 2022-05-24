package com.example.coinpocket.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = arrayOf(CompanyListingEntity::class,CoinEntity::class),
    version = 1,
    exportSchema = false
)
abstract class CoinPocketDatabase:RoomDatabase() {
    abstract val coinDao:CoinDao
    abstract val stockDao:StockDao
}