package com.daoflowers.catalog.di

import com.daoflowers.catalog.data.repo.CatalogRepo
import com.daoflowers.catalog.data.repo.CatalogRepoImpl
import com.daoflowers.catalog.domain.GetFlowerTypesUseCase
import org.koin.dsl.module

val catalogModule = module {
    single<CatalogRepo> { CatalogRepoImpl() }
    single { GetFlowerTypesUseCase(get()) }
}