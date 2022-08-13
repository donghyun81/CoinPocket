package com.example.coinpocket.presentation.coin_main

import com.example.coinpocket.data.local.AmountEntity

sealed class CoinMainEvent{
        data class OnDeleteCoinClick(val amountEntity: AmountEntity):CoinMainEvent()
        object OnUndoDeleteClick:CoinMainEvent()
        data class OnSelectDay(val day:String):CoinMainEvent()
}
