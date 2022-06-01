package com.example.coinpocket.util


sealed class Screens(val route: String) {
    object Home : Screens("home")
    object SearchStock : Screens("search?query={query}")
    object Profile : Screens("profile/{id}?isEditable={isEditable}")

}
