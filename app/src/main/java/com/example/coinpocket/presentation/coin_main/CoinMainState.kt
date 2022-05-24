package com.example.coinpocket.presentation.coin_main

import com.example.coinpocket.data.local.CoinEntity

data class CoinMainState(
    val coinEntity: List<CoinEntity> = emptyList(),

)
