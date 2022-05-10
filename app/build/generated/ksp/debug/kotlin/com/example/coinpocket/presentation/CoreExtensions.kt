package com.example.coinpocket.presentation

import androidx.navigation.NavBackStackEntry
import com.example.coinpocket.presentation.destinations.*
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.utils.findDestination

/**
 * Realization of [NavGraphSpec] for the app.
 * It uses [TypedDestination] instead of [DestinationSpec].
 * 
 * @see [NavGraphSpec]
 */
data class NavGraph(
    override val route: String,
    override val startDestination: Destination,
    val destinations: List<Destination>,
    override val nestedNavGraphs: List<NavGraph> = emptyList()
): NavGraphSpec {
    override val destinationsByRoute: Map<String, Destination> = destinations.associateBy { it.route }
}

/**
 * Finds the destination correspondent to this [NavBackStackEntry] in the root NavGraph, null if none is found
 * or if no route is set in this back stack entry's destination.
 */
val NavBackStackEntry.navDestination: Destination?
    get() {
        return navDestination()
    }

/**
 * Finds the destination correspondent to this [NavBackStackEntry] in [navGraph], null if none is found
 * or if no route is set in this back stack entry's destination.
 */
fun NavBackStackEntry.navDestination(navGraph: NavGraph = NavGraphs.root): Destination? {
    return destination.route?.let { navGraph.findDestination(it) as Destination }
}