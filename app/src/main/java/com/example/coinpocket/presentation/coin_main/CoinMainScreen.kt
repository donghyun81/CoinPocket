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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.presentation.coin_main.components.CoinMainItem
import com.example.coinpocket.presentation.destinations.AmountDetailScreenDestination
import com.example.coinpocket.presentation.destinations.CoinAddSalaryScreenDestination
import com.example.coinpocket.presentation.destinations.CoinStatisticsScreenDestination
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
                monthHeader = { MonthHeader(monthState = it)},
                weekHeader = { WeekHeader(daysOfWeek = it)},
                calendarState = calendarState
            )
            Spacer(modifier = Modifier.height(16.dp))
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
                }
            }
    }

    }
    }


@RequiresApi(Build.VERSION_CODES.O)
@Composable
public fun <T : SelectionState> DefaultDay(
    state: DayState<T>,
    modifier: Modifier = Modifier,
    selectionColor: Color = MaterialTheme.colors.secondary,
    currentDayColor: Color = MaterialTheme.colors.primary,
    onClick: (LocalDate) -> Unit = {},
    amountEntitys:List<AmountEntity>,
) {
    val date = state.date
    val selectionState = state.selectionState
    val isSelected = selectionState.isDateSelected(date)
    val inCome = amountEntitys.totalDayIncome(date.toString())
    Card(
        modifier = modifier
            .aspectRatio(1f)
            .padding(2.dp),
        elevation = if (state.isFromCurrentMonth) 4.dp else 0.dp,
        border = if (state.isCurrentDay) BorderStroke(1.dp, currentDayColor) else null,
        contentColor = if (isSelected) selectionColor else contentColorFor(
            backgroundColor = MaterialTheme.colors.surface
        )
    ) {
        Box(
            modifier = Modifier.clickable {
                onClick(date)
                selectionState.onDateSelected(date)
            },
            contentAlignment = Alignment.TopCenter,
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = date.dayOfMonth.toString(),
                    style = MaterialTheme.typography.subtitle2,

                    )
                Text(
                    fontSize = 12.sp,
                    text = inCome,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun WeekHeader(daysOfWeek: List<DayOfWeek>) {
    Row {
        daysOfWeek.forEach { dayOfWeek ->
            Text(
                textAlign = TextAlign.Center,
                text = dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREA),
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
            )
        }
    }
}

@Composable
private fun SelectionControls(
    selectionState: DynamicSelectionState,
) {
    Text(
        text = "Calendar Selection Mode",
        style = MaterialTheme.typography.h5,
    )
    SelectionMode.values().forEach { selectionMode ->
        Row(modifier = Modifier.fillMaxWidth()) {
            RadioButton(
                selected = selectionState.selectionMode == selectionMode,
                onClick = { selectionState.selectionMode = selectionMode }
            )
            Text(text = selectionMode.name)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }

    Text(
        text = "Selection: ${selectionState.selection.joinToString { it.toString() }}",
        style = MaterialTheme.typography.h6,
    )
}