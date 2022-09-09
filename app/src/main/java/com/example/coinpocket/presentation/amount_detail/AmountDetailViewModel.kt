package com.example.coinpocket.presentation.amount_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinpocket.domain.use_case.amount.AmountUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AmountDetailViewModel @Inject constructor(
    private val amountUseCases: AmountUseCases,
    private val savedStateHandle: SavedStateHandle
):ViewModel() {

    private val _state = mutableStateOf(AmountDetailState())
    val state: State<AmountDetailState> = _state

    private var currentAmountId: Int? = null

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    init {
                viewModelScope.launch {
                    val amountId = savedStateHandle.get<Int>("amountId") ?: return@launch
                    if (amountId != -1) {
                    amountUseCases.getAmount(amountId)?.also { amountEntity ->
                        currentAmountId = amountEntity.id
                        _state.value = state.value.copy(
                            day=amountEntity.day,
                            categoryImage = amountEntity.categoryImage,
                            isDeposit=amountEntity.isDeposit,
                            amount =amountEntity.amount,
                            title=amountEntity.title,
                            content=amountEntity.content,
                      )
                }
            }
        }
    }

    fun onEvent(event: AmountDetailEvent){
        when(event) {
            is AmountDetailEvent.UpdateSalary ->{
                viewModelScope.launch {
                    try {
                        amountUseCases.updateAmount(
                                day =state.value.day,
                                categoryImage =state.value.categoryImage,
                                isDeposit =state.value.isDeposit,
                                amount =state.value.amount,
                                title =state.value.title,
                                content =state.value.content,
                                id=currentAmountId
                        )
                        _eventFlow.emit(UiEvent.UpdateAmount)

                    }catch (e:Exception){
                        _eventFlow.emit(
                           UiEvent.ShowSnackbar(
                                message = e.message ?: "Couldn't update amount"
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
                    categoryImage = event.categoryImage
                )
            }
        }
    }

    fun getIsDeposit(isDeposit:Boolean){
        _state.value = state.value.copy(
            isDeposit = isDeposit
        )
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String): UiEvent()
        object UpdateAmount: UiEvent()
    }
}
