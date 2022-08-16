package com.example.coinpocket.domain.use_case

import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.repository.AmountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetDayAccounts(
    private val repository:AmountRepository
    ){
       operator fun invoke(day:String) : Flow<List<AmountEntity>> {
            return repository.getDayAccounts(day)
        }

}