package com.example.coinpocket.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.coinpocket.presentation.NavGraphs
import com.example.coinpocket.presentation.destinations.*

@Composable
fun TopBar(
    destination:Destination,
    onStatistics:()->Unit,
    onCalendarSettings:()->Unit,
    navBackStackEntry: NavBackStackEntry?
){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(MaterialTheme.colors.primary)
        ){
       if(NavGraphs.root.destinations.contains(destination)){
           IconButton(
               onClick = onStatistics,
               modifier = Modifier.align(Alignment.CenterStart)
           ) {
               Icon(
                   imageVector = Icons.Outlined.Menu,
                   tint = Color.White,
                   contentDescription = "statistics"
               )
           }
       }
        Text(
            text =destination.topBarTitle(navBackStackEntry =navBackStackEntry ),
            modifier = Modifier.align(Alignment.Center),
            color = Color.White
        )
        if(NavGraphs.root.destinations.contains(destination)){
            IconButton(
                onClick = onCalendarSettings,
                modifier = Modifier.align(Alignment.CenterStart)
                ) {
                Icon(
                    imageVector = Icons.Outlined.Menu,
                    tint = Color.White,
                    contentDescription = ""

                )
            }
        }
    }
}

@Composable
fun Destination.topBarTitle(navBackStackEntry: NavBackStackEntry?): String {
    return when (this) {
        CoinMainScreenDestination,
        CoinAddSalaryScreenDestination,
        CoinStatisticsScreenDestination,
        AmountDetailScreenDestination,
        CompanyListingScreenDestination -> javaClass.simpleName.removeSuffix("Destination")
    }
}