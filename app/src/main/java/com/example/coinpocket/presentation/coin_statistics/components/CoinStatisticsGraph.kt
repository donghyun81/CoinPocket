package com.example.coinpocket.presentation.coin_statistics.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.model.StatisticModel


@Composable
fun CategoryGraph(
    statisticList: List<StatisticModel?>,
    modifier: Modifier = Modifier
) {
    val stroke = with(LocalDensity.current) { Stroke(50.dp.toPx()) }
    val animateFloat = remember { Animatable(0f) }

    LaunchedEffect(animateFloat) {
        animateFloat.snapTo(0f)
        animateFloat.animateTo(
            targetValue = 1f,
            animationSpec = repeatable(
                iterations = 1,
                animation = tween(
                    durationMillis = 900,
                    easing = LinearOutSlowInEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    Canvas(modifier) {
        val innerRadius = (size.minDimension - stroke.width) / 2
        val halfSize = size / 2.0f
        val topLeft = Offset(
            halfSize.width - innerRadius,
            halfSize.height - innerRadius
        )
        val size = Size(innerRadius * 2, innerRadius * 2)
        var startAngle = -90f

        statisticList.forEach { item ->
            item?.let {
                val sweep = it.percentage * 360 * animateFloat.value
                drawArc(
                    color = Color(it.color),
                    startAngle = startAngle,
                    sweepAngle = sweep,
                    topLeft = topLeft,
                    size = size,
                    useCenter = false,
                    style = stroke
                )
                startAngle += sweep
            }
        }
    }
}
