package com.example.coinpocket.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.coinpocket.R

data class IconSample(
    val id:Long,
    val icon:ImageVector
)

data class ImageSample(
    val id:Long,
    val imageUrl:Int
)

val imageSamples = listOf(
    ImageSample(
        id=1L,
        imageUrl = R.drawable.img
    ),
    ImageSample(
        id=2L,
        imageUrl = R.drawable.img_1
    )
)
val iconSamples = listOf(
    IconSample(
        id=1L,
        icon = Icons.Default.AccountCircle
    ),
    IconSample(
        id=2L,
        icon = Icons.Default.AccountBalance
    ),
    IconSample(
        id=3L,
        icon = Icons.Default.AddCircle
    ),
    IconSample(
        id=4L,
        icon = Icons.Default.BorderRight
    ),
    IconSample(
        id=5L,
        icon = Icons.Default.ControlCamera
    ),
    IconSample(
        id=6L,
        icon = Icons.Default.Brush
    ),
    IconSample(
        id=7L,
        icon = Icons.Default.BrunchDining
    ),
    IconSample(
        id=8L,
        icon = Icons.Default.Apartment
    )
)