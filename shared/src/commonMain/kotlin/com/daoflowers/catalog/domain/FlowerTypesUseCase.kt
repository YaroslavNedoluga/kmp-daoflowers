package com.daoflowers.catalog.domain

import com.daoflowers.catalog.data.model.FlowerType
import com.daoflowers.catalog.data.repo.CatalogRepo
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

class FlowerTypesUseCase constructor(
    private val repo: CatalogRepo
) {
    suspend operator fun invoke(): ImmutableList<FlowerType> {
        return repo.flowerTypes()
            .sortedWith(compareBy<FlowerType> { it.isGroup }.thenBy { it.position })
            .map {
                it.imgUrl?.let { url ->
                    if (url.contains("http") && !url.contains("https")) {
                        it.copy(imgUrl = url.replace("http", "https"))
                    } else {
                        it
                    }
                } ?: it
            }
            .toImmutableList()
    }
}