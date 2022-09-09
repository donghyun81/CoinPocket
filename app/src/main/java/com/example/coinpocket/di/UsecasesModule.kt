package com.example.coinpocket.di

import com.example.coinpocket.domain.repository.AmountRepository
import com.example.coinpocket.domain.repository.StockRepository
import com.example.coinpocket.domain.use_case.amount.*
import com.example.coinpocket.domain.use_case.stock.GetCompaniesFromDBUseCase
import com.example.coinpocket.domain.use_case.stock.GetCompaniesUseCase
import com.example.coinpocket.domain.use_case.stock.StockUsecases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UsecasesModule {

    @Provides
    @Singleton
    fun provideAmountUseCases(repository: AmountRepository): AmountUseCases {
        return AmountUseCases(
            getAmount = GetAmount(repository = repository),
            addAmount = AddAmount(repository = repository),
            getDayAccounts = GetDayAccounts(repository=repository),
            deleteAmount = DeleteAmount(repository),
            updateAmount = UpdateAmount(repository),
            getAmounts = GetAmounts(repository),
        )
    }

    @Provides
    @Singleton
    fun provideStockUseCases(repository: StockRepository): StockUsecases{
        return StockUsecases(
            getCompaniesFromDBUseCase = GetCompaniesFromDBUseCase(repository),
            getCompaniesUseCase = GetCompaniesUseCase(repository)
        )
    }
}