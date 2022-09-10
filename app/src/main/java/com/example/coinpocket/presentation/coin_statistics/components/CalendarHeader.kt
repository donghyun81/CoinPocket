package com.example.coinpocket.presentation.coin_statistics.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import io.github.boguszpawlowski.composecalendar.header.MonthState
import java.time.format.TextStyle
import java.util.*

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
            IconButton(
                onClick = {
                monthState.currentMonth = monthState.currentMonth.minusMonths(1)
            },
            ) {
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