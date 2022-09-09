package com.example.coinpocket.domain.use_case.stock

data class StockUsecases(
    val getCompaniesFromDBUseCase: GetCompaniesFromDBUseCase,
    val getCompaniesUseCase: GetCompaniesUseCase
)