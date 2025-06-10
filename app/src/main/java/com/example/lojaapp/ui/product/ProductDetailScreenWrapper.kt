package com.example.lojaapp.ui.product

import ProductDetailScreen
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProductDetailScreenWrapper(productId: String?) {
    val viewModel: ProductViewModel = viewModel()

    val product = remember { productId?.let { viewModel.getProductById(it) } }

    if (product != null) {
        ProductDetailScreen(product = product)
    } else {
        Text("Produto não encontrado")
    }
}