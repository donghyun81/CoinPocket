package com.example.coinpocket.presentation.amount_detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.coinpocket.R
import com.example.coinpocket.domain.model.iconSamples
import com.example.coinpocket.presentation.amount_add_category.component.CategoryIconItem
import com.example.coinpocket.presentation.coin_add_salary.CoinAddSalaryEvent
import com.example.coinpocket.presentation.coin_add_salary.CoinAddSalaryViewModel
import com.example.coinpocket.presentation.coin_add_salary.components.TitleAndAmountField
import com.example.coinpocket.presentation.coin_add_salary.components.TitleAndTextField
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Destination
@Composable
fun AmountDetailScreen(
    id:Int,
    navigator: DestinationsNavigator,
    viewModel: AmountDetailViewModel
) {
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val state = viewModel.state.value

    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is AmountDetailViewModel.UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                is AmountDetailViewModel.UiEvent.SaveAmount -> {
                    navigator.navigateUp()
                }
            }
        }
    }

    BottomSheetScaffold(
        sheetContent = {
            LazyVerticalGrid(
                cells = GridCells.Fixed(4),
                contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
            ) {
                items(iconSamples) { icon ->
                    CategoryIconItem(
                        modifier = Modifier.clickable {
                            viewModel.onEvent(AmountDetailEvent.OnSelectIcon(icon.icon))
                            scope.launch {
                                sheetState.collapse()
                            }
                        },
                        icon = icon.icon
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(AmountDetailEvent.UpdateSalary)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = "Save note")
            }
        },
        scaffoldState = scaffoldState,

        ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = state.day!!
            )
            Button(
                onClick = {
                    scope.launch {
                        sheetState.expand()
                    }
                }
            ) {
                CategoryIconItem(icon = state.icon)
            }

            CategoryIconItem(icon = state.icon)
        }
            Spacer(modifier = Modifier.height(16.dp))
            TitleAndAmountField(
            title= R.string.amount,
            text = state.amount.toString(),
            onValueChange = {
                viewModel.onEvent(AmountDetailEvent.EnteredAmount(it.toInt()))
            },
            keyboardType = KeyboardType.Number,
            singleLine = true,
            textStyle = MaterialTheme.typography.h5,
            won = R.string.won
        )
            Spacer(modifier = Modifier.height(16.dp))
            TitleAndTextField(
            title=R.string.title,
            text =state.title,
            onValueChange = {
                viewModel.onEvent(AmountDetailEvent.EnteredTitle(it))
            },

            singleLine = true,
            textStyle = MaterialTheme.typography.h5
        )
            Spacer(modifier = Modifier.height(16.dp))
            TitleAndTextField(
            title=R.string.content,
            text = state.content,
            onValueChange = {
                viewModel.onEvent(AmountDetailEvent.EnteredContent(it))
            },
            singleLine = true,
            textStyle = MaterialTheme.typography.h5
        )
        }
    }