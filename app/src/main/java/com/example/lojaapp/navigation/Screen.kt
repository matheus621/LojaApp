package com.example.lojaapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Cart : Screen("cart")
    object Profile : Screen("profile")
    object ProductDetail : Screen("product_detail")
}