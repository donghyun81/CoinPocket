package com.example.coinpocket.presentation.coin_statistics

import android.graphics.Color
import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.model.StatisticModel

data class CoinStatisticsState(
    val amountList: List<AmountEntity> = emptyList(),
    val color:Int = Color.BLUE,
    val categoryTotalAmountById:Long= 0L,
    val percentage:Float = 0f,
    val yearMonth:String ="",
    val isDeposit:Boolean = true,
    val expenseStaticList:List<StatisticModel> = emptyList(),
    val incomeStaticList:List<StatisticModel> = emptyList()
)