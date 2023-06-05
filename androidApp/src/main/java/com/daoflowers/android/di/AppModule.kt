package com.daoflowers.android.di

import com.daoflowers.android.MainViewModel
import com.daoflowers.android.ui.catalog.flower.FlowerTypesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    viewModel {
        MainViewModel(get())
    }

    viewModel {
        FlowerTypesViewModel(get())
    }
}