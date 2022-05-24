package com.example.coinpocket.presentation.coin_main

import androidx.lifecycle.ViewModel
import com.example.coinpocket.domain.repository.CoinRepository
import com.example.coinpocket.domain.use_case.CoinUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinMainViewModel @Inject constructor(
    private val useCases: CoinUseCases
):ViewModel() {
        val Coins=useCases.getCoin

    fun onEvent(event: CoinMainEvent) {
        when(event) {
            is CoinMainEvent.OnCoinClick-> {

            }
        }
    }
}