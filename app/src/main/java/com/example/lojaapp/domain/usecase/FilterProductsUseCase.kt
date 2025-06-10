package com.example.lojaapp.domain.usecase

import com.example.lojaapp.domain.model.Product

class FilterProductsUseCase {
    operator fun invoke(products: List<Product>, query: String): List<Product> {
        return products.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}