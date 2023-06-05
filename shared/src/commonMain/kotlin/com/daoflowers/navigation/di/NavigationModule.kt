package com.daoflowers.navigation.di

import com.daoflowers.navigation.domain.usecase.GetBottomNavItemsUseCase
import org.koin.dsl.module

val navigationModule = module {
    single { GetBottomNavItemsUseCase() }
}