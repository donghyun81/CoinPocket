package com.example.coinpocket.presentation.amount_add_category.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.coinpocket.ui.composables.CoinPocketSurface


@Composable
fun CategoryIconItem(
    @DrawableRes imageUrl:Int,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,
    color:Long
) {
    CoinPocketSurface(
        color = color,
        elevation = elevation,
        modifier = modifier
    ) {
        Image(
            modifier = Modifier.size(72.dp),
            painter = BitmapPainter(ImageBitmap.imageResource(id = imageUrl)),
            contentDescription = null
        )
    }
}
