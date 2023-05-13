package com.daoflowers.catalog.di

import com.daoflowers.catalog.data.repo.CatalogRepo
import com.daoflowers.catalog.data.repo.CatalogRepoImpl
import com.daoflowers.catalog.domain.FlowerTypesUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val catalogModule = module {
    single<CatalogRepo> { CatalogRepoImpl() }
    factory { FlowerTypesUseCase(get()) }
}