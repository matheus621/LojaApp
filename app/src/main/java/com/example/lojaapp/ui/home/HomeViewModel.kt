package com.example.lojaapp.ui.home

import androidx.lifecycle.ViewModel
import com.example.lojaapp.data.ProductRepository
import com.example.lojaapp.domain.usecase.FilterProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel(
    private val filterProductsUseCase: FilterProductsUseCase,
    private val repository: ProductRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts() {
        val products = repository.getProducts()
        _state.update {
            it.copy(allProducts = products, filteredProducts = products)
        }
    }

    fun onIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.Search -> {
                _state.update {
                    val filtered = filterProductsUseCase(it.allProducts, intent.query)
                    it.copy(searchQuery = intent.query, filteredProducts = filtered)
                }
            }
            is HomeIntent.SelectCategory -> {
                _state.update {
                    val filtered = if (intent.category == "Todos") {
                        it.allProducts
                    } else {
                        it.allProducts.filter { product ->
                            product.category.contains(intent.category, ignoreCase = true)
                        }
                    }

                    it.copy(
                        selectedCategory = intent.category,
                        filteredProducts = filtered
                    )
                }
            }
        }
    }
}
