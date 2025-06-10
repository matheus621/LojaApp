package com.example.lojaapp.ui.home

sealed class HomeIntent {
    data class Search(val query: String) : HomeIntent()
    data class SelectCategory(val category: String) : HomeIntent()
}
