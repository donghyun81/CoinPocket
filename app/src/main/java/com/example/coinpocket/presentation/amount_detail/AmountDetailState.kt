package com.example.coinpocket.presentation.amount_detail

import com.example.coinpocket.domain.model.IconSample
import com.example.coinpocket.domain.model.iconSamples

data class AmountDetailState (
    val day:String?=null,
    val iconSample: IconSample? = null,
    val isDeposit:Boolean = true,
    val amount:Int=0,
    val title:String? = null,
    val content:String?=null,
)