package com.example.coinpocket.presentation.amount_detail

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.coinpocket.domain.model.IconSample
import com.example.coinpocket.presentation.coin_add_salary.CoinAddSalaryEvent

sealed class AmountDetailEvent {
    object UpdateSalary: AmountDetailEvent()
    data class OnClickIsDeposit(val deposit:Boolean): AmountDetailEvent()
    data class EnteredAmount(val amount: Int): AmountDetailEvent()
    data class EnteredTitle(val title: String): AmountDetailEvent()
    data class EnteredContent(val content: String): AmountDetailEvent()
    data class OnSelectIcon(val icon:ImageVector): AmountDetailEvent()
}