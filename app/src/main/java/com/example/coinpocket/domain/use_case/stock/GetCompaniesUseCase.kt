package com.example.coinpocket.domain.use_case.stock

import com.example.coinpocket.domain.repository.StockRepository

class GetCompaniesUseCase(private val stockRepository: StockRepository) {
    operator fun invoke() = stockRepository.getCompanise()
}