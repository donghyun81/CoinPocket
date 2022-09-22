package com.example.coinpocket.presentation.coin_main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.presentation.coin_main.components.CoinMainItem
import com.example.coinpocket.presentation.coin_main.components.DefaultDay
import com.example.coinpocket.presentation.coin_main.components.MonthHeader
import com.example.coinpocket.presentation.coin_main.components.WeekHeader
import com.example.coinpocket.presentation.destinations.AmountDetailScreenDestination
import com.example.coinpocket.presentation.destinations.CoinAddSalaryScreenDestination
import com.example.coinpocket.presentation.destinations.CoinStatisticsScreenDestination
import com.example.coinpocket.ui.composables.HorizontalDividerMax
import com.example.coinpocket.util.ext.totalDayExpense
import com.example.coinpocket.util.ext.totalDayIncome
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.header.MonthState
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import io.github.boguszpawlowski.composecalendar.selection.SelectionState
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Destination(
    start = true
)
@Composable
fun CoinMainScreen(
    navigator: DestinationsNavigator,
    viewModel: CoinMainViewModel= hiltViewModel()
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val calendarState = rememberSelectableCalendarState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
            navigator.navigate(
               CoinAddSalaryScreenDestination(day =state.day )
            )
                },
            backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription ="Add Money" )
            }
        }
    ) {
        Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
            SelectableCalendar(
                modifier = Modifier.animateContentSize(),
                dayContent = {
                    DefaultDay(
                        state = it,
                        onClick = { selectedDay->
                            viewModel.onEvent(CoinMainEvent.OnSelectDay(selectedDay.toString()))
                        },
                        amountEntitys = state.getAmounts,
                    )
                },
                monthHeader = { MonthHeader(monthState = it) },
                weekHeader = { WeekHeader(daysOfWeek = it)},
                calendarState = calendarState
            )
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDividerMax()
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(state.getDayAmountEntity) { amountEntity ->
                    CoinMainItem(
                        modifier = Modifier.clickable {
                            navigator.navigate(AmountDetailScreenDestination(amountId = amountEntity.id))
                        },
                        amountEntity = amountEntity,
                        onDeleteClick = {
                                viewModel.onEvent (CoinMainEvent.OnDeleteCoinClick(amountEntity))
                            scope.launch {
                                val result = scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Coin deleted",
                                    actionLabel = "Undo"
                                )
                                if(result == SnackbarResult.ActionPerformed) {
                                    viewModel.onEvent(CoinMainEvent.OnUndoDeleteClick)
                                }
                            }
                        }
                    )
                    HorizontalDividerMax()
                }
            }
    }
    }
    }
