package com.daoflowers.di

import com.daoflowers.catalog.domain.GetFlowerTypesUseCase
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