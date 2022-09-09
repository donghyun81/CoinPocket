package com.example.coinpocket.presentation.coin_statistics

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinpocket.domain.model.CategoryImage
import com.example.coinpocket.domain.model.StatisticModel
import com.example.coinpocket.domain.model.expenseCategoryImages
import com.example.coinpocket.domain.model.incomeCategoryImages
import com.example.coinpocket.domain.use_case.amount.AmountUseCases
import com.example.coinpocket.util.ext.categoryTotalExpenseById
import com.example.coinpocket.util.ext.categoryTotalIncomeById
import com.example.coinpocket.util.ext.totalDayIncome
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class CoinStatisticsViewModel @Inject constructor(
    private val useCases: AmountUseCases,
):ViewModel(){

    private var getAmountsJob: Job? = null


    private val _state= mutableStateOf(CoinStatisticsState())
    val state: State<CoinStatisticsState> = _state

    init {
        getAmouts()
    }

    fun getYearMonth(yearMonth:String){
        _state.value = state.value.copy(
            yearMonth = yearMonth
        )
    }



    fun getStaticsList(
        expenseTotal:Float,
        incomeTotal:Float,
        yearMonth: String
        ){
        val expenseStaticList = mutableListOf<StatisticModel>()
        expenseCategoryImages.onEachIndexed(){
            index, categoryImage ->
            expenseStaticList.add(
                index,
                StatisticModel(
                    categoryId = categoryImage.id,
                    imageUrl = categoryImage.imageUrl,
                    color = categoryImage.color,
                    amount = state.value.amountList
                        .categoryTotalExpenseById(
                            categoryImage.id,
                            yearMonth),
                ).refreshPercentage(expenseTotal.toLong())
            )
        }
        val incomeStaticList = mutableListOf<StatisticModel>()
        incomeCategoryImages.onEachIndexed(){
                index, categoryImage ->
            incomeStaticList.add(
                index,
                StatisticModel(
                    categoryId = categoryImage.id,
                    imageUrl = categoryImage.imageUrl,
                    color = categoryImage.color,
                    amount = state.value.amountList.
                    categoryTotalIncomeById(categoryImage.id,yearMonth),
                ).refreshPercentage(incomeTotal.toLong())
            )
        }
    _state.value = state.value.copy(
        incomeStaticList = incomeStaticList,
        expenseStaticList = expenseStaticList
    )

    }

    fun getIsDeposit(isDeposit:Boolean){
        _state.value = state.value.copy(
            isDeposit = isDeposit
        )
    }

    private fun getAmouts() {
        getAmountsJob?.cancel()
        getAmountsJob = useCases.getAmounts()
            .onEach { amounts ->
                _state.value = state.value.copy(
                    amountList = amounts
                )
            }
            .launchIn(viewModelScope)

    }

}