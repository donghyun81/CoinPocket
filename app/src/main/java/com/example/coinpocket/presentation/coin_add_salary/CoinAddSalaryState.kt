package com.example.coinpocket.presentation.coin_add_salary

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.coinpocket.domain.model.IconSample
import com.example.coinpocket.domain.model.ImageSample
import com.example.coinpocket.domain.model.iconSamples
import com.example.coinpocket.domain.model.imageSamples

data class CoinAddSalaryState (
    val day:String="",
    val image:Int= imageSamples[0].imageUrl,
    val isDeposit:Boolean = true,
    val amount:Int=0,
    val title:String = "",
    val content:String="",
        )