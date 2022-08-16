package com.example.coinpocket.domain.use_case

import com.example.coinpocket.domain.repository.AmountRepository
import kotlinx.coroutines.flow.Flow

class GetDayAmount (
    private val repository: AmountRepository
        ){
     operator fun invoke(day:String): Flow<List<Int>> {
        return repository.getDayAmout(day)
    }
}