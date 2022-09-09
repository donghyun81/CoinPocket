package com.example.coinpocket.presentation.coin_statistics

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coinpocket.domain.model.expenseCategoryImages
import com.example.coinpocket.presentation.coin_add_salary.components.DepositButton
import com.example.coinpocket.presentation.coin_main.CoinMainEvent
import com.example.coinpocket.presentation.coin_main.CoinMainViewModel
import com.example.coinpocket.presentation.coin_main.DefaultDay
import com.example.coinpocket.presentation.coin_statistics.components.CategoryGraph
import com.example.coinpocket.presentation.coin_statistics.components.CategoryText
import com.example.coinpocket.presentation.coin_statistics.components.TotalText
import com.example.coinpocket.presentation.destinations.CoinAddSalaryScreenDestination
import com.example.coinpocket.util.ext.*
import com.ramcosta.composedestinations.annotation.Destination
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.header.MonthState
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Destination
@Composable
fun CoinStatisticsScreen(
    viewModel: CoinStatisticsViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    val totalIncome = state.amountList.totalYearMonthIncome(state.yearMonth)
    val totalExpese = state.amountList.totalYearMonthExpense(state.yearMonth)
    val pattern = "yyyy-MM"
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    val calendarState = rememberSelectableCalendarState()
    val isDepositState = remember{ mutableStateOf(true) }
    viewModel.getIsDeposit(isDepositState.value)
    viewModel.getStaticsList(
        expenseTotal = totalExpese.toFloat(),
        incomeTotal = totalIncome.toFloat(),
        yearMonth = state.yearMonth
    )
    Scaffold {
        Column(Modifier.padding(16.dp)) {
            SelectableCalendar(
                modifier = Modifier.animateContentSize(),
                dayContent = {},
                weekHeader = {},
                monthHeader = {
                    MonthHeader(monthState = it)
                    viewModel.getYearMonth(it.currentMonth.format(formatter))
                },
                calendarState = calendarState
            )
            DepositButton(isIncomeState =isDepositState )
            if(isDepositState.value) {
                TotalText(amount = totalIncome)
                CategoryGraph(
                    statisticList = state.incomeStaticList,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp, 0.dp)
                ) {
                    items(state.incomeStaticList) { item ->
                        item?.let {
                            CategoryText(item = it)
                        }
                    }
                }
            }else{
                TotalText(amount = totalExpese)
                CategoryGraph(
                    statisticList = state.expenseStaticList,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp, 0.dp)
                ) {
                    items(state.expenseStaticList) { item ->
                        item?.let {
                            CategoryText(item = it)
                        }
                    }
                }

            }


            Text(text = totalIncome.toString())
            Text(text = totalExpese.toString())
        }

    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun MonthHeader(monthState: MonthState) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = {
                monthState.currentMonth = monthState.currentMonth.minusMonths(1)
            }) {
                Image(
                    imageVector = Icons.Default.ArrowLeft,
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
                    contentDescription = "Previous",
                )
            }
            Text(
                monthState.currentMonth.month.getDisplayName(TextStyle.NARROW, Locale.KOREA),
                style = MaterialTheme.typography.h3
            )
            IconButton(onClick = {
                monthState.currentMonth = monthState.currentMonth.plusMonths(1)
            }) {
                Image(
                    imageVector = Icons.Default.ArrowRight,
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
                    contentDescription = "Next",
                )
            }
        }
    }
}

