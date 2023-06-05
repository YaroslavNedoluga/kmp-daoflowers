package com.daoflowers.di

import com.daoflowers.catalog.domain.GetFlowerTypesUseCase
import com.daoflowers.navigation.domain.usecase.GetBottomNavItemsUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            appModules
        )
    }
}

class CatalogKoinModule : KoinComponent {
    val getFlowerTypesUseCase: GetFlowerTypesUseCase by inject()
}

class NavigationKoinModule : KoinComponent {
    val getBottomNavItemsUseCase: GetBottomNavItemsUseCase by inject()
}