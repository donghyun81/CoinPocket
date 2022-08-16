package com.example.coinpocket.domain.use_case

import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.repository.AmountRepository
import kotlinx.coroutines.flow.Flow

class GetAmounts(
    private val repository: AmountRepository
) {
    operator fun invoke(): Flow<List<AmountEntity>>{
        return repository.getAccounts()
    }
}