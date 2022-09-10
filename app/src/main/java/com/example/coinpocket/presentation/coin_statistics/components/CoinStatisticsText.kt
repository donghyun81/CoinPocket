package com.example.coinpocket.presentation.coin_statistics.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coinpocket.domain.model.CategoryImage
import com.example.coinpocket.domain.model.StatisticModel
import com.example.coinpocket.util.ext.format
import com.example.coinpocket.util.ext.justMoney

@Composable
fun CategoryText(
    item: StatisticModel,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        with(item) {
            CategoryView(
                item = CategoryImage(categoryId,imageUrl, color,)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = item.amount.toInt().justMoney(),
            fontSize = 14.sp,
            modifier = Modifier
                .weight(1f)
        )
        Text(
            text = "${(item.percentage * 100).format(2)}%",
            fontSize = 14.sp,
        )
    }
}

@Composable
fun CategoryView(item: CategoryImage) {
    Card(
        modifier = Modifier
            .background(
                color = Color(item.color),
                shape = RoundedCornerShape(corner = CornerSize(999.dp))
            )
            .width(56.dp)
            .padding(4.dp),
        backgroundColor = Color(item.color),
        elevation = 0.dp
    ) {
        Image(
            modifier = Modifier.size(64.dp),
            painter = BitmapPainter(ImageBitmap.imageResource(id = item.imageUrl)),
            contentDescription = null
        )
    }
}

@Composable
fun TotalText(amount: Long) {
    Column {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "이번 달 총 지출 금액",
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = amount.toInt().justMoney(),
                fontSize = 14.sp
            )
        }
    }
}