package com.example.coinpocket.presentation.coin_add_salary

import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.model.CategoryImage


sealed class CoinAddSalaryEvent {
        object SaveSalary: CoinAddSalaryEvent()
        data class OnClickIsDeposit(val deposit:Boolean):CoinAddSalaryEvent()
        data class EnteredAmount(val amount: Long): CoinAddSalaryEvent()
        data class EnteredTitle(val title: String): CoinAddSalaryEvent()
        data class EnteredContent(val content: String): CoinAddSalaryEvent()
        data class OnSelectIcon(val categoryImage: CategoryImage): CoinAddSalaryEvent()
}