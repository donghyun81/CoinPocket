package com.example.coinpocket.presentation.coin_add_salary.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp





@Composable
fun DepositButton(
    isIncomeState: MutableState<Boolean>,
    modifier: Modifier= Modifier,
    onDepositClick:()->Unit
) {
    val title = remember { mutableStateOf("지출") }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title.value,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            color=if(isIncomeState.value) Color.Red else Color.Blue,
            modifier = modifier
                .clickable(onClick = onDepositClick)
                .clickable {
                    if (!isIncomeState.value) {
                        title.value = "지출"
                        isIncomeState.value = !isIncomeState.value
                    } else {
                        title.value = "수입"
                        isIncomeState.value = !isIncomeState.value
                    }
                },
        )
    }

}