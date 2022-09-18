package com.example.coinpocket.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.coinpocket.domain.model.CompanyListRemoteKeys
import com.example.coinpocket.domain.model.CompanyListingEntity

@Database(
    entities = [CompanyListingEntity::class, AmountEntity::class, CompanyListRemoteKeys::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(ImageTypeConverter::class)
abstract class CoinPocketDatabase:RoomDatabase() {
    abstract val amountDao:AmountDao
    abstract fun stockDao():CompaniesDao
    abstract fun stockRemoteKeys():CompaniesRemoteKeysDao
}