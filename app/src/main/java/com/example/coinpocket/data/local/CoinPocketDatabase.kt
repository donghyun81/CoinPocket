package com.example.coinpocket.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = arrayOf(CompanyListingEntity::class,AmountEntity::class),
    version = 1
)
@TypeConverters(ImageVectorTypeConverter::class)
abstract class CoinPocketDatabase:RoomDatabase() {
    abstract val amountDao:AmountDao
    abstract val stockDao:StockDao
}