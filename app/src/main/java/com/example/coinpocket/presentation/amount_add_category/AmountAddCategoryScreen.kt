package com.example.coinpocket.presentation.amount_add_category

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coinpocket.domain.model.IconSample
import com.example.coinpocket.domain.model.imageSamples
import com.example.coinpocket.presentation.amount_add_category.component.CategoryIconItem
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalFoundationApi::class)
@Destination
@Composable
fun AmountAddCategoryScreen(
    iconSamples: List<IconSample>,
    amountAddCategoryState: AmountAddCategoryState,
    modifier:Modifier= Modifier
) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "name")
               BasicTextField(
                   value =amountAddCategoryState.title ,
                   onValueChange = {
                       }
                       )
                   }
            }

            Row( 
                modifier = Modifier.fillMaxSize(),
            )
             {
                 LazyVerticalGrid(
                     cells = GridCells.Fixed(5),
                     modifier = modifier,
                     contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
                 ) {
                     items(imageSamples) { image ->
                         CategoryIconItem(imageUrl = image.imageUrl)
                     }
                 }
                
            }
            
        }
