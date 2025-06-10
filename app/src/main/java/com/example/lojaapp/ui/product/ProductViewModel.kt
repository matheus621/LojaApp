package com.example.lojaapp.ui.product

import androidx.lifecycle.ViewModel
import com.example.lojaapp.data.ProductRepository
import com.example.lojaapp.domain.model.Product

class ProductViewModel: ViewModel() {
    private val productRepository = ProductRepository()

    fun getProductById(productId: String) : Product? {
        return productRepository.getProductById(productId)
    }
}