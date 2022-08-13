package com.example.coinpocket.presentation.amount_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.model.iconSamples
import com.example.coinpocket.domain.use_case.AmountUseCases
import com.example.coinpocket.presentation.coin_add_salary.CoinAddSalaryEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AmountDetailViewModel @Inject constructor(
    private val amountUseCases: AmountUseCases,
    savedStateHandle: SavedStateHandle
):ViewModel() {

    private val _state = mutableStateOf(AmountDetailState())
    val state: State<AmountDetailState> = _state

    private var currentAmountId: Int? = null

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    init {
        savedStateHandle.get<Int>("amountId")?.let { amountId ->
            if (amountId != -1) {
                viewModelScope.launch {
                    amountUseCases.getCoin(amountId)?.also { amountEntity ->
                        currentAmountId = amountEntity.id
                        _state.value = state.value.copy(
                            day=amountEntity.day,
                            icon = amountEntity.icon,
                            isDeposit=amountEntity.isDeposit,
                            amount =amountEntity.amount,
                            title=amountEntity.title,
                            content=amountEntity.content,
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: AmountDetailEvent){
        when(event) {
            is AmountDetailEvent.UpdateSalary ->{
                val day= state.value.day
                val title =state.value.title
                val content =state.value.content
                viewModelScope.launch {
                    try {
                        amountUseCases.updateAmount(
                                day =day,
                                icon =state.value.icon,
                                isDeposit =state.value.isDeposit,
                                amount =state.value.amount,
                                title =title,
                                content =content,
                                id=currentAmountId
                        )


                    }catch (e:Exception){
                        _eventFlow.emit(
                           UiEvent.ShowSnackbar(
                                message = e.message ?: "Couldn't save amount"
                            )
                        )
                    }
                }
            }
            is AmountDetailEvent.OnClickIsDeposit ->{

            }

            is AmountDetailEvent.EnteredAmount ->{
                _state.value = state.value.copy(
                    amount = event.amount
                )
            }
            is AmountDetailEvent.EnteredTitle ->{
                _state.value = state.value.copy(
                    title = event.title
                )
            }
            is AmountDetailEvent.EnteredContent ->{
                _state.value = state.value.copy(
                    content = event.content
                )
            }
            is AmountDetailEvent.OnSelectIcon ->{
                _state.value = state.value.copy(
                    icon = event.icon
                )
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String): UiEvent()
        object SaveAmount: UiEvent()
    }
}
