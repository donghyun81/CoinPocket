package com.example.coinpocket.util

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.plusAssign
import com.example.coinpocket.presentation.NavGraphs
import com.example.coinpocket.presentation.appCurrentDestinationAsState
import com.example.coinpocket.presentation.destinations.Destination
import com.example.coinpocket.presentation.navDestination
import com.example.coinpocket.presentation.startAppDestination
import com.ramcosta.composedestinations.spec.Route

@Composable
fun SampleScaffold(
    startRoute: Route,
    navController: NavHostController,
    bottomBar: @Composable (Destination) -> Unit,
    topBar:@Composable (Destination,NavBackStackEntry?) ->Unit,
    content: @Composable (PaddingValues) -> Unit

) {
    val destination = navController.appCurrentDestinationAsState().value
        ?: startRoute.startAppDestination
    val navBackStackEntry = navController.currentBackStackEntry

        Scaffold(
            topBar = {  topBar(destination,navBackStackEntry)},
            bottomBar = { bottomBar(destination) },
            content = content
        )
    }