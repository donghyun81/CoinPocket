package com.example.coinpocket.presentation.amount_detail

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.coinpocket.domain.model.IconSample
import com.example.coinpocket.domain.model.iconSamples
import com.example.coinpocket.domain.model.imageSamples

data class AmountDetailState (
    val day:String="",
    val imageUrl:Int = imageSamples[0].imageUrl,
    val isDeposit:Boolean = true,
    val amount:Int=0,
    val title:String = "",
    val content:String="",
)