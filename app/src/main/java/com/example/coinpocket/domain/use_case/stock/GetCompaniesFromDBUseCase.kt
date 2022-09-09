package com.example.coinpocket.domain.use_case.stock

import com.example.coinpocket.domain.repository.StockRepository

class GetCompaniesFromDBUseCase (private val stockRepository: StockRepository) {
    operator fun invoke(id: Int) = stockRepository.getCompanyFromDB(id)
}