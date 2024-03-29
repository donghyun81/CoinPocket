package com.example.coinpocket.presentation.coin_main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.use_case.amount.AmountUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class CoinMainViewModel @Inject constructor(
    private val useCases: AmountUseCases,
):ViewModel() {

    private val _state = mutableStateOf(CoinMainState())
    val state: State<CoinMainState> = _state


    private var getDayAccountsJob: Job? = null
    private var getAmountsJob: Job? = null



    init {
        getDayAccounts(day = state.value.day)
        getAmouts()
    }


    fun onEvent(event: CoinMainEvent) {
        when (event) {
            is CoinMainEvent.OnDeleteCoinClick -> {
                viewModelScope.launch {
                    useCases.deleteAmount(event.amountEntity)
                }
            }
            is CoinMainEvent.OnSelectDay -> {
                _state.value = state.value.copy(
                    day = event.day
                )
                getDayAccounts(event.day)
            }
        }

    }

    private fun getDayAccounts(day: String) {
        getDayAccountsJob?.cancel()
        getDayAccountsJob = useCases.getDayAccounts(day)
            .onEach { dayAccounts ->
                _state.value = state.value.copy(
                    getDayAmountEntity = dayAccounts
                )
            }.launchIn(viewModelScope)
    }


    private fun getAmouts() {
        getAmountsJob?.cancel()
        getAmountsJob = useCases.getAmounts()
            .onEach { dayAmount ->
                _state.value = state.value.copy(
                    getAmounts = dayAmount
                )
            }
            .launchIn(viewModelScope)

    }


}



