package com.example.coinpocket.presentation.amount_detail

import com.example.coinpocket.domain.model.CategoryImage


sealed class AmountDetailEvent {
    object UpdateSalary: AmountDetailEvent()
    data class OnClickIsDeposit(val deposit:Boolean): AmountDetailEvent()
    data class EnteredAmount(val amount: Int): AmountDetailEvent()
    data class EnteredTitle(val title: String): AmountDetailEvent()
    data class EnteredContent(val content: String): AmountDetailEvent()
    data class OnSelectIcon(val categoryImage: CategoryImage): AmountDetailEvent()
}