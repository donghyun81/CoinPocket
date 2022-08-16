package com.example.coinpocket.domain.use_case

import com.example.coinpocket.domain.repository.AmountRepository
import kotlinx.coroutines.flow.Flow

class GetDays(
    private val repository: AmountRepository
) {
    operator fun invoke(): Flow<List<String>> {
        return repository.getDays()
    }
}
