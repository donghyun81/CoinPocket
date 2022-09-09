package com.example.coinpocket.domain.use_case.amount

import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.repository.AmountRepository

class DeleteAmount(
    private val repository: AmountRepository
) {

    suspend operator fun invoke(amountEntity: AmountEntity) {
        repository.deleteCoin(amountEntity)
    }
}