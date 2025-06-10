package com.example.lojaapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lojaapp.ui.cart.CartScreen
import com.example.lojaapp.ui.home.HomeScreen
import com.example.lojaapp.ui.product.ProductDetailScreenWrapper
import com.example.lojaapp.ui.profile.ProfileScreen

@Composable
fun LojaAppScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },
        containerColor = Color.White
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) { HomeScreen(navController) }
            composable(Screen.Cart.route) {
                CartScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable("${Screen.ProductDetail.route}/{productId}") { backStackEntry ->
                val productId = backStackEntry.arguments?.getString("productId")
                ProductDetailScreenWrapper(productId)
            }
        }
    }
}
