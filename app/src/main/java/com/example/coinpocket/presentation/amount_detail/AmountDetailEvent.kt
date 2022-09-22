package com.example.coinpocket.presentation.amount_detail

import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.model.CategoryImage
import com.example.coinpocket.presentation.coin_add_salary.CoinAddSalaryEvent


sealed class AmountDetailEvent {
    object UpdateSalary: AmountDetailEvent()
    data class OnClickIsDeposit(val deposit:Boolean): AmountDetailEvent()
    data class EnteredAmount(val amount: Long): AmountDetailEvent()
    data class EnteredTitle(val title: String): AmountDetailEvent()
    data class EnteredContent(val content: String): AmountDetailEvent()
    data class OnSelectIcon(val categoryImage: CategoryImage): AmountDetailEvent()
    data class OnDeleteCoinClick(val amountEntity: AmountEntity): AmountDetailEvent()

}