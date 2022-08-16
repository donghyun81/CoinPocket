package com.example.coinpocket.presentation.coin_add_salary

import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.coinpocket.domain.model.IconSample

sealed class CoinAddSalaryEvent {
        object SaveSalary: CoinAddSalaryEvent()
        data class OnClickIsDeposit(val deposit:Boolean):CoinAddSalaryEvent()
        data class EnteredAmount(val amount: Int): CoinAddSalaryEvent()
        data class EnteredTitle(val title: String): CoinAddSalaryEvent()
        data class EnteredContent(val content: String): CoinAddSalaryEvent()
        data class OnSelectIcon(val imageUrl: Int): CoinAddSalaryEvent()
}