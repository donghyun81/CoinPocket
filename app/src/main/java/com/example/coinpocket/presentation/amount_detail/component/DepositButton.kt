package com.example.coinpocket.presentation.amount_detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp





@Composable
fun DepositButton(
    isIncomeState: MutableState<Boolean>,
    modifier: Modifier= Modifier,
) {
    val title = remember { mutableStateOf("수입") }
    Text(
        text = title.value,
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        color=if(isIncomeState.value) Color.Red else Color.Blue,
        modifier = modifier
            .padding(16.dp, 8.dp)
            .clickable {
                    if (!isIncomeState.value) {
                        isIncomeState.value = !isIncomeState.value
                        title.value = "지출"
                    }
                    else {
                        isIncomeState.value = !isIncomeState.value
                        title.value = "수입"
                    }
            }
    )
}