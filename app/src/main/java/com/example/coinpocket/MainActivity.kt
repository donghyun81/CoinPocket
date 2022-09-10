package com.example.coinpocket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.coinpocket.presentation.NavGraphs
import com.example.coinpocket.presentation.destinations.CoinStatisticsScreenDestination
import com.example.coinpocket.ui.composables.BottomBar
import com.example.coinpocket.ui.composables.TopBar
import com.example.coinpocket.ui.theme.CoinPocketTheme
import com.example.coinpocket.util.SampleScaffold
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.navigateTo
import com.ramcosta.composedestinations.rememberNavHostEngine
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinPocketTheme {
               MainScreen()
            }
        }
    }
}




@Composable
fun MainScreen() {
    val engine = rememberNavHostEngine()
    val navController = engine.rememberNavController()
    val startRoute =NavGraphs.root.startRoute

    SampleScaffold(
            startRoute = startRoute,
            navController = navController,
            bottomBar ={
                BottomBar(navController)
            },
           topBar = {dest,backStackEntry->
               TopBar(
               destination = dest,
               onStatistics = { navController.navigate(CoinStatisticsScreenDestination) },
               onCalendarSettings = {  navController.navigate(CoinStatisticsScreenDestination) },
               navBackStackEntry =backStackEntry
           )
           })
    {
        DestinationsNavHost(
        engine = engine,
        navController = navController,
        navGraph = NavGraphs.root,
        modifier = Modifier.padding(it),
        startRoute = startRoute
        )
        
    }
}





@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoinPocketTheme {
        MainScreen()
    }
}