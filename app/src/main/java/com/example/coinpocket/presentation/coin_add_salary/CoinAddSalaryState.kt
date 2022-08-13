package com.example.coinpocket.presentation.coin_add_salary

import com.example.coinpocket.domain.model.IconSample
import com.example.coinpocket.domain.model.iconSamples

data class CoinAddSalaryState (
    val day:String="",
    val iconSample: IconSample= iconSamples[0],
    val isDeposit:Boolean = true,
    val amount:Int=0,
    val title:String = "",
    val content:String="",
        )