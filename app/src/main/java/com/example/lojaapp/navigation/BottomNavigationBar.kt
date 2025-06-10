package com.example.lojaapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController?) {
    val items = listOf(Screen.Home, Screen.Cart, Screen.Profile)
    val navBackStackEntry = navController?.currentBackStackEntryAsState()?.value
    val currentDestination = navBackStackEntry?.destination

    val isProductDetailRoute = currentDestination?.route?.startsWith(Screen.ProductDetail.route) == true

    if (isProductDetailRoute) return

    NavigationBar(containerColor = Color.White) {
        items.forEach { screen ->
            val selected = currentDestination?.route == screen.route
            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected) {
                        navController?.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = when (screen) {
                            Screen.Home -> Icons.Default.Home
                            Screen.Cart -> Icons.Default.ShoppingCart
                            Screen.Profile -> Icons.Default.Person
                            else -> Icons.Default.Info
                        },
                        contentDescription = screen.route
                    )
                },
                label = { Text(screen.route.replaceFirstChar { it.uppercase() }) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFFF7A00),
                    selectedTextColor = Color(0xFFFF7A00),
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}