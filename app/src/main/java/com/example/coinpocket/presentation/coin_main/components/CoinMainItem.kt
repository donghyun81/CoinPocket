package com.example.coinpocket.presentation.coin_main.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.coinpocket.R
import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.presentation.amount_add_category.component.CategoryIconItem


@Composable
fun CoinMainItem(
    amountEntity: AmountEntity,
    onDeleteClick:() ->Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        CategoryIconItem(
            imageUrl = amountEntity.categoryImage.imageUrl,
            color = amountEntity.categoryImage.color
        )
        Column(
            modifier = modifier.padding(10.dp)
        ) {
            Text(
                text = amountEntity.title,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = amountEntity.content,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(Modifier.weight(1f))
        Text(
            text = amountEntity.amount.toString()+
                    stringResource(id =R.string.won ),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface,
            maxLines = 10,
            overflow = TextOverflow.Ellipsis
        )
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
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
    }
}