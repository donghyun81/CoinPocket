package com.example.coinpocket


sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Stock : NavRoutes("stock")
    object Settings : NavRoutes("settings")
}
