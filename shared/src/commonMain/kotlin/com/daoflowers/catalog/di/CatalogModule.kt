package com.daoflowers.catalog.di

import com.daoflowers.catalog.data.repo.CatalogRepo
import com.daoflowers.catalog.data.repo.CatalogRepoImpl
import com.daoflowers.catalog.domain.flower.GetFlowerTypesUseCase
import com.daoflowers.catalog.domain.flower.SearchFlowersUseCase
import com.daoflowers.catalog.ui.flower.FlowerTypeMapper
import com.daoflowers.catalog.ui.flower.search.FlowerSearchMapper
import org.koin.dsl.module

val catalogModule = module {
    single<CatalogRepo> { CatalogRepoImpl() }
    single { GetFlowerTypesUseCase(get()) }
    single { SearchFlowersUseCase(get()) }
    single { FlowerTypeMapper() }
    single { FlowerSearchMapper() }
}