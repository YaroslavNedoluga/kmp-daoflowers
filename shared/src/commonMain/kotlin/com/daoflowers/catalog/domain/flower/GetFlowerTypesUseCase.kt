package com.daoflowers.catalog.domain.flower

import com.daoflowers.catalog.data.model.FlowerType
import com.daoflowers.catalog.data.repo.CatalogRepo
import com.daoflowers.util.replaceHttp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

class GetFlowerTypesUseCase constructor(
    private val repo: CatalogRepo
) {
    suspend operator fun invoke(): ImmutableList<FlowerType> {
        return repo.flowerTypes()
            .sortedWith(compareBy<FlowerType> { it.isGroup ?: false }.thenBy { it.position })
            .map { it.copy(imgUrl = it.imgUrl.replaceHttp()) }
            .toImmutableList()
    }
}