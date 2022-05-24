package com.example.coinpocket.data.repository

import androidx.room.Update
import com.example.coinpocket.data.local.CoinEntity
import com.example.coinpocket.data.local.CoinDao
import com.example.coinpocket.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class CoinRepositoryImpl(private val dao: CoinDao):CoinRepository {
    override suspend fun insertCoin(coinEntity: CoinEntity) {
        dao.InsertCoin(coinEntity = coinEntity)
    }

    override suspend fun getCoin(id: Int): CoinEntity? {
       return dao.getCoin(id)
    }




}