package com.example.coinpocket.presentation.coin_add_salary

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.data.local.InvalidAmountException
import com.example.coinpocket.domain.model.iconSamples
import com.example.coinpocket.domain.use_case.AmountUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class CoinAddSalaryViewModel @Inject constructor(
    private val amountUseCases: AmountUseCases,
    private val savedStateHandle: SavedStateHandle
):ViewModel() {


    private val _state = mutableStateOf(CoinAddSalaryState())
    val state: State<CoinAddSalaryState> = _state



    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            _state.value=state.value.copy(
                day=savedStateHandle.get<String>("day") ?:return@launch
            )
        }
    }

    fun onEvent(event: CoinAddSalaryEvent) {
        when (event) {
            is CoinAddSalaryEvent.SaveSalary -> {
                viewModelScope.launch {
                        amountUseCases.addAmount(
                            AmountEntity(
                                day =state.value.day,
                                imageUrl =state.value.image,
                                isDeposit =state.value.isDeposit,
                                amount =state.value.amount,
                                title = state.value.title,
                                content =state.value.content,
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveNote)
                }
            }
            is CoinAddSalaryEvent.OnClickIsDeposit ->{

            }

            is CoinAddSalaryEvent.EnteredAmount ->{
                when(event.amount) {
                   is Int -> {
                        _state.value = state.value.copy(
                            amount = event.amount
                        )
                    }
                   else -> {
                       _state.value = state.value.copy(
                           amount = 0
                       )
                   }
                }


                }
            is CoinAddSalaryEvent.EnteredTitle ->{
                _state.value = state.value.copy(
                    title = event.title
                )
            }
            is CoinAddSalaryEvent.EnteredContent ->{
                _state.value = state.value.copy(
                    content = event.content
                )
            }
            is CoinAddSalaryEvent.OnSelectIcon ->{
                _state.value = state.value.copy(
                    image = event.imageUrl
                )
            }
        }
    }
    sealed class UiEvent {
        data class ShowSnackbar(val message: String): UiEvent()
        object SaveNote: UiEvent()
    }
}


