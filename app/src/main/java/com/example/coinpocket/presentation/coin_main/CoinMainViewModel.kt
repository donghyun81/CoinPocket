package com.example.coinpocket.presentation.coin_main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.use_case.AmountUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinMainViewModel @Inject constructor(
    private val useCases: AmountUseCases,
    savedStateHandle: SavedStateHandle
):ViewModel() {

    private var recentlyDeletedCoin: AmountEntity? = null

        private val _state = mutableStateOf(CoinMainState())
        val state: State<CoinMainState> = _state



    init {

        viewModelScope.launch {
             useCases.getDayAccounts(state.value.day)
        }

        }


    fun onEvent(event: CoinMainEvent){
        when(event) {
         is CoinMainEvent.OnDeleteCoinClick ->{
             viewModelScope.launch{
                 useCases.deleteAmount(event.amountEntity)
                 recentlyDeletedCoin = event.amountEntity
             }
          }
         is CoinMainEvent.OnUndoDeleteClick ->{
             viewModelScope.launch {
                 useCases.addAmount(recentlyDeletedCoin?:return@launch)
                 recentlyDeletedCoin = null
             }
         }
         is CoinMainEvent.OnSelectDay ->{
           _state.value = state.value.copy(
                day = event.day
           )
         }
        }

    }


    }





