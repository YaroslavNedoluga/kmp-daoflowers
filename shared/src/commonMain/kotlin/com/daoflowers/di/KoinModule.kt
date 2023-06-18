package com.daoflowers.di

import com.daoflowers.catalog.domain.flower.GetFlowerTypesUseCase
import com.daoflowers.catalog.domain.flower.SearchFlowersUseCase
import com.daoflowers.catalog.ui.flower.FlowerTypeMapper
import com.daoflowers.catalog.ui.flower.search.FlowerSearchMapper
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
    val searchFlowersUseCase: SearchFlowersUseCase by inject()
    val flowerTypeMapper: FlowerTypeMapper by inject()
    val flowerSearchMapper: FlowerSearchMapper by inject()
}

class NavigationKoinModule : KoinComponent {
    val getBottomNavItemsUseCase: GetBottomNavItemsUseCase by inject()
}