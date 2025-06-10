package com.example.lojaapp.domain.model

data class Product(
    val id: Int,
    val name: String,
    val price: String,
    val imageUrl: String,
    val category: String,
    val description: String
)
