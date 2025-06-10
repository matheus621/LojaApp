package com.example.lojaapp.di

import com.example.lojaapp.data.ProductRepository
import com.example.lojaapp.domain.usecase.FilterProductsUseCase
import com.example.lojaapp.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Repository
    single { ProductRepository() }

    // UseCase
    single { FilterProductsUseCase() }

    // ViewModel
    viewModel { HomeViewModel(get(), get()) }
}