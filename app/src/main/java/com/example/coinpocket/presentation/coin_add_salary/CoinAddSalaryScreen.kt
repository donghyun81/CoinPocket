package com.example.coinpocket.presentation.coin_add_salary

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coinpocket.R
import com.example.coinpocket.domain.model.iconSamples
import com.example.coinpocket.presentation.amount_add_category.component.CategoryIconItem
import com.example.coinpocket.presentation.coin_add_salary.components.TitleAndAmountField
import com.example.coinpocket.presentation.coin_add_salary.components.TitleAndTextField
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Destination
@Composable
fun CoinAddSalaryScreen(
    day:String,
    navigator: DestinationsNavigator,
    viewModel: CoinAddSalaryViewModel = hiltViewModel()
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
            when(event) {
                is CoinAddSalaryViewModel.UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                is CoinAddSalaryViewModel.UiEvent.SaveNote -> {
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
                           viewModel.onEvent(CoinAddSalaryEvent.OnSelectIcon(icon))
                            scope.launch {
                                    sheetState.collapse()
                            }
                        },
                        iconSample = icon
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(CoinAddSalaryEvent.SaveSalary)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = "Save note")
            }
        },
        sheetPeekHeight = 0.dp,
        scaffoldState = scaffoldState,

    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text =day
                )
            Button(
                onClick = {
                    scope.launch {
                        sheetState.expand()
                    }
                }
            ) {
                CategoryIconItem(iconSample = state.iconSample)
            }
            Spacer(modifier = Modifier.height(16.dp))
            TitleAndAmountField(
                title= R.string.amount,
                text = state.amount.toString(),
                onValueChange = {
                                viewModel.onEvent(CoinAddSalaryEvent.EnteredAmount(it.toInt()))
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
                                viewModel.onEvent(CoinAddSalaryEvent.EnteredTitle(it))
                },

                singleLine = true,
                textStyle = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(16.dp))
            TitleAndTextField(
                title=R.string.content,
                text = state.content,
                onValueChange = {
                                viewModel.onEvent(CoinAddSalaryEvent.EnteredContent(it))
                },
                singleLine = true,
                textStyle = MaterialTheme.typography.h5
            )
        }
    }

}