package com.daoflowers.di

import com.daoflowers.catalog.di.catalogModule
import com.daoflowers.navigation.di.navigationModule

val appModules = listOf(
    catalogModule,
    navigationModule
)