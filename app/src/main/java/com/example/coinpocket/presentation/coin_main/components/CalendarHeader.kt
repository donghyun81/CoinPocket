package com.example.coinpocket.presentation.coin_main.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.util.ext.totalDayExpense
import com.example.coinpocket.util.ext.totalDayIncome
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.header.MonthState
import io.github.boguszpawlowski.composecalendar.selection.SelectionState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun <T : SelectionState> DefaultDay(
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
    val totalDayIncome = amountEntitys.totalDayIncome(date.toString())
    val totalDayExpense= amountEntitys.totalDayExpense(date.toString())
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
                    text = totalDayIncome,
                    color= Color.Blue,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    fontSize = 12.sp,
                    text = totalDayExpense,
                    color= Color.Red,
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
fun MonthHeader(monthState: MonthState) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
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
fun WeekHeader(daysOfWeek: List<DayOfWeek>) {
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