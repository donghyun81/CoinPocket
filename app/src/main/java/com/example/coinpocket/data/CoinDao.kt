package com.example.coinpocket.data

import androidx.room.*

@Dao
interface CoinDao {

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun InsertCoin(coin:Coin)

    @Delete
    suspend fun DeleteCoin(coin: Coin)

    @Query("Select * From Coin ")
    suspend fun getCoin()
}