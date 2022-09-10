package com.example.coinpocket.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalDividerMax(
    height: Int = 1,
    color: Color = Color.DarkGray,
    modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier
            .fillMaxWidth()
            .height(height.dp)
            .background(color)
    )
}