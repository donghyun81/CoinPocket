package com.example.coinpocket.presentation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainer
import com.ramcosta.composedestinations.navargs.DestinationsStringNavType
import com.ramcosta.composedestinations.spec.Direction
import androidx.compose.runtime.remember
import androidx.lifecycle.SavedStateHandle
import com.example.coinpocket.presentation.company_info.CompanyinfoScreen

object CompanyinfoScreenDestination : TypedDestination<CompanyinfoScreenDestination.NavArgs> {
         
    operator fun invoke(
		symbol: String,
    ): Direction {
        return object : Direction {
            override val route = "companyinfo_screen" + 
					"/${DestinationsStringNavType.encodeForRoute(symbol, true)}"
        }
    }
    
    override val route = "companyinfo_screen/{symbol}"
    
	override val arguments get() = listOf(
		navArgument("symbol") {
			type = DestinationsStringNavType
		}
	)

    @Composable
    override fun Content(
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
        dependencyContainer: DestinationDependenciesContainer
    ) {
		val (symbol) = remember { argsFrom(navBackStackEntry) }
		CompanyinfoScreen(
			symbol = symbol
		)
    }
                    
	override fun argsFrom(navBackStackEntry: NavBackStackEntry): NavArgs {
	    return NavArgs(
			symbol = navBackStackEntry.arguments?.getString("symbol") ?: throw RuntimeException("'symbol' argument is mandatory, but was not present!"),
	    )
	}
                
	override fun argsFrom(savedStateHandle: SavedStateHandle): NavArgs {
	    return NavArgs(
			symbol = savedStateHandle.get<String>("symbol") ?: throw RuntimeException("'symbol' argument is mandatory, but was not present!"),
	    )
	}

	data class NavArgs(
		val symbol: String,
	)
}