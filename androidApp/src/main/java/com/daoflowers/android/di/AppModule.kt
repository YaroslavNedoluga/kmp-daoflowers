package com.daoflowers.android.di

import com.daoflowers.android.MainViewModel
import com.daoflowers.android.ui.catalog.flower.FlowerTypesViewModel
import com.daoflowers.android.ui.catalog.flower.search.FlowerSearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    viewModel { MainViewModel(get()) }

    viewModel { FlowerTypesViewModel(get(), get()) }
    viewModel { FlowerSearchViewModel(get(), get()) }
}