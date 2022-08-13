package com.example.coinpocket.presentation.coin_main.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.coinpocket.data.local.AmountEntity


@Composable
fun CoinMainItem(
    amountEntity: AmountEntity,
    onDeleteClick:() ->Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(end = 32.dp)
    ) {
        Text(
            text = amountEntity.day,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = amountEntity.content,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface,
            maxLines = 10,
            overflow = TextOverflow.Ellipsis
        )
    }
    IconButton(
        onClick = onDeleteClick,
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Delete note",
            tint = MaterialTheme.colors.onSurface
        )
    }

}