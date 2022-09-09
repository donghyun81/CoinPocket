package com.example.coinpocket.domain.model

import android.graphics.Color
import androidx.annotation.DrawableRes

data class StatisticModel(
    val categoryId: Long,
    @DrawableRes val imageUrl: Int,
    val color: Long,
    val amount: Long,
    val percentage: Float = 0f
){
    fun refreshPercentage(total: Long): StatisticModel {
        return StatisticModel(
            categoryId,
            imageUrl,
            color,
            amount,
            (amount.toFloat() / total)
        )
    }
}
