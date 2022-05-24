package com.example.coinpocket.domain.use_case
import com.example.coinpocket.data.local.InvalidCoinException
import com.example.coinpocket.data.local.CoinEntity
import com.example.coinpocket.domain.repository.CoinRepository

class AddCoin (
    private val repository: CoinRepository
        ){
    @Throws(InvalidCoinException::class)
    suspend operator fun invoke(coinEntity: CoinEntity){
        if (coinEntity.money.isEmpty()) {
            throw InvalidCoinException("월급값이 비었습니다")
        }
        if (coinEntity.day.isEmpty()) {
            throw InvalidCoinException("월급날을 지정해주세요")
        }
    repository.insertCoin(coinEntity = coinEntity)
    }
}