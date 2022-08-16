package com.example.coinpocket.presentation.amount_add_category.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.coinpocket.domain.model.IconSample
import com.example.coinpocket.domain.model.iconSamples
import com.example.coinpocket.domain.model.imageSamples
import com.example.coinpocket.ui.composables.CoinPocketSurface


@Composable
fun CategoryIconItem(
    @DrawableRes imageUrl:Int = imageSamples[0].imageUrl,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    CoinPocketSurface(
        color = Color.LightGray,
        elevation = elevation,
        shape = CircleShape,
        modifier = modifier
    ) {
        Image(
            modifier = Modifier.size(64.dp),
            painter = BitmapPainter(ImageBitmap.imageResource(id = imageUrl)),
            contentDescription = null
        )
    }
}
