package com.example.coinpocket.domain.use_case
import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.repository.AmountRepository

class AddAmount (
    private val repository: AmountRepository
        ){
    suspend operator fun invoke(amountEntity: AmountEntity){
    repository.insertAmount(amountEntity = amountEntity)
    }
}