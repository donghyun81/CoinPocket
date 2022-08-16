package com.example.coinpocket.presentation.coin_main

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.coinpocket.data.local.AmountEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
data class CoinMainState(
    val getDayAmountEntity: List<AmountEntity> = emptyList(),
    val day:String = LocalDate.now().toString(),
    val getAmounts:List<AmountEntity> = emptyList(),
    )
