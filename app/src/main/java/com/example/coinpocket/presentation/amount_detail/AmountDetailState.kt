package com.example.coinpocket.presentation.amount_detail

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.coinpocket.domain.model.IconSample
import com.example.coinpocket.domain.model.iconSamples

data class AmountDetailState (
    val day:String="",
    val icon:ImageVector = iconSamples[0].icon,
    val isDeposit:Boolean = true,
    val amount:Int=0,
    val title:String = "",
    val content:String="",
)