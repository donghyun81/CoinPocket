package com.example.coinpocket.domain.use_case

import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.repository.AmountRepository

class GetAmount(
private val repository: AmountRepository){
    suspend operator fun invoke(id:Int):AmountEntity?{
       return repository.getAmount(id)
    }
}