package com.example.coinpocket.presentation.coin_main

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.coinpocket.data.local.AmountEntity
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
data class CoinMainState(
    val amountEntity: List<AmountEntity> = emptyList(),
    val day:String =LocalDate.now().toString()
    )
