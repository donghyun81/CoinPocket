package com.example.coinpocket.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Amount(
    val id: Int? = null,
    val isDeposit:Boolean,
    val title:String,
    val day: String,
    val icon: IconSample,
    val content:String?,
    val amount:Int
)