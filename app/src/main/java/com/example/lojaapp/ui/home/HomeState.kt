package com.example.lojaapp.ui.home

import com.example.lojaapp.domain.model.Product

data class HomeState(
    val searchQuery: String = "",
    val selectedCategory: String = "Todos",
    val allProducts: List<Product> = emptyList(),
    val filteredProducts: List<Product> = emptyList()
)
