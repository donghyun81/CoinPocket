package com.example.coinpocket.util


sealed class BottomNavScreen(val route: String) {
    object Home : BottomNavScreen("home")
    object SearchStock : BottomNavScreen("search?query={query}")
    object Profile : BottomNavScreen("profile/{id}?isEditable={isEditable}")
}
