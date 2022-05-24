package com.example.coinpocket.domain.repository

import androidx.room.Update
import com.example.coinpocket.data.local.CoinEntity
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun insertCoin(coinEntity:CoinEntity)


    suspend fun getCoin(id: Int): CoinEntity?


}