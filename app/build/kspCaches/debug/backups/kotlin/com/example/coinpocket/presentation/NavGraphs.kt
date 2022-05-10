package com.example.coinpocket.presentation

import com.example.coinpocket.presentation.destinations.*

/**
 * Class generated if any Composable is annotated with `@Destination`.
 * It aggregates all [TypedDestination]s in their [NavGraph]s.
 */
object NavGraphs {

    val root = NavGraph(
        route = "root",
        startDestination = CompanyListingScreenDestination,
        destinations = listOf(
            CompanyinfoScreenDestination,
			CompanyListingScreenDestination
        )
    )
}