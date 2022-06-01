package com.example.coinpocket.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun InsertCoin(coinEntity: CoinEntity)

    @Query("select * from CoinEntity where id= :id")
    suspend fun getCoin(id:Int):CoinEntity?

}