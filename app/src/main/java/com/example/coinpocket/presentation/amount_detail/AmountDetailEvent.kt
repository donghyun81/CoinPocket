package com.example.coinpocket.presentation.amount_detail

import com.example.coinpocket.domain.model.IconSample

sealed class AmountDetailEvent {
    object UpdateSalary: AmountDetailEvent()
    data class OnclickSelect(val icon: IconSample): AmountDetailEvent()
}