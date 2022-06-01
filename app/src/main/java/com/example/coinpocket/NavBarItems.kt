package com.example.coinpocket

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "home"
        ),
        BarItem(
            title = "Stock",
            image = Icons.Filled.Face,
            route = "stock"
        ),
        BarItem(
            title = "Settings",
            image = Icons.Filled.Favorite,
            route = "settings"
        )
    )
}
//data class BottomNavItem(
//    val name:String,
//    val route:String,
//    val icon: ImageVector,
//    val badgeCount:Int = 0
//)