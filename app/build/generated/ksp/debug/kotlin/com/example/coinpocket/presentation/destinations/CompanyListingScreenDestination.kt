package com.example.coinpocket.presentation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainer
import com.ramcosta.composedestinations.navargs.DestinationsStringNavType
import com.ramcosta.composedestinations.spec.Direction
import com.example.coinpocket.presentation.company_listings.CompanyListingScreen
import com.ramcosta.composedestinations.navigation.DestinationsNavController

object CompanyListingScreenDestination : DirectionDestination {
         
    operator fun invoke() = this
    
    override val route = "company_listing_screen"
    
    @Composable
    override fun Content(
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
        dependencyContainer: DestinationDependenciesContainer
    ) {
		CompanyListingScreen(
			navigator = DestinationsNavController(navController, navBackStackEntry)
		)
    }
    
}