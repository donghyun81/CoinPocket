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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coinpocket.R
import com.example.coinpocket.domain.model.expenseCategoryImages
import com.example.coinpocket.domain.model.incomeCategoryImages
import com.example.coinpocket.presentation.amount_add_category.component.CategoryIconItem
import com.example.coinpocket.presentation.coin_add_salary.components.DepositButton
import com.example.coinpocket.presentation.coin_add_salary.components.TitleAndAmountField
import com.example.coinpocket.presentation.coin_add_salary.components.TitleAndTextField
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Destination()
@Composable
fun AmountDetailScreen(
    amountId:Int?,
    navigator: DestinationsNavigator,
    viewModel: AmountDetailViewModel = hiltViewModel()
) {
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()
    val isDepositState = remember{ mutableStateOf(state.isDeposit)}
    viewModel.getIsDeposit(isDepositState.value)
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is AmountDetailViewModel.UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                is AmountDetailViewModel.UiEvent.UpdateAmount -> {
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
                    if(isDepositState.value) {
                        items(incomeCategoryImages) { image ->
                            CategoryIconItem(
                                modifier = Modifier.clickable {
                                    viewModel.onEvent(AmountDetailEvent.OnSelectIcon(image))
                                    scope.launch {
                                        sheetState.collapse()
                                    }
                                },
                                imageUrl = image.imageUrl,
                                color = image.color
                            )
                        }
                    }
                    else{
                        items(expenseCategoryImages) { image ->
                            CategoryIconItem(
                                modifier = Modifier.clickable {
                                    viewModel.onEvent(AmountDetailEvent.OnSelectIcon(image))
                                    scope.launch {
                                        sheetState.collapse()
                                    }
                                },
                                imageUrl = image.imageUrl,
                                color = image.color
                            )
                        }
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
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)        ,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text =state.day
            )
            Button(
                onClick = {
                    scope.launch {
                        if (sheetState.isCollapsed) {
                            sheetState.expand()
                        } else {
                            sheetState.collapse()
                        }
                    }
                }
            ) {
                CategoryIconItem(
                    imageUrl = state.categoryImage.imageUrl,
                    color= state.categoryImage.color
                )
            }


            DepositButton(
                isIncomeState= isDepositState,
            )
            TitleAndAmountField(
                title= R.string.amount,
                text = state.amount.toString(),
                onValueChange = {
                    if(it==""){
                        viewModel.onEvent(AmountDetailEvent.EnteredAmount(0))
                    }
                    else{
                        viewModel.onEvent(AmountDetailEvent.EnteredAmount(it.toInt()))

                    }
                },
                keyboardType = KeyboardType.Number,
                singleLine = true,
                textStyle = MaterialTheme.typography.h5,
                won = R.string.won
            )
            TitleAndTextField(
                title=R.string.title,
                text =state.title,
                onValueChange = {
                    viewModel.onEvent(AmountDetailEvent.EnteredTitle(it))
                },

                singleLine = true,
                textStyle = MaterialTheme.typography.h5
            )
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
    }