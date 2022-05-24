package com.example.coinpocket.presentation.coin_main

import com.example.coinpocket.data.local.CoinEntity

sealed class CoinMainEvent{
        data class OnCoinClick(val coinEntity: CoinEntity):CoinMainEvent()
}
