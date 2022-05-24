package com.example.coinpocket.domain.use_case

import com.example.coinpocket.data.local.CoinEntity
import com.example.coinpocket.domain.repository.CoinRepository

class GetCoin(
private val repository: CoinRepository){
    suspend operator fun invoke(id:Int):CoinEntity?{
       return repository.getCoin(id)
    }
}