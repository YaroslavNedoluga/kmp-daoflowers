package com.daoflowers.catalog.domain.flower

import com.daoflowers.catalog.data.model.FlowerSort
import com.daoflowers.catalog.data.repo.CatalogRepo
import com.daoflowers.util.replaceHttp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

class SearchFlowersUseCase constructor(
    private val repo: CatalogRepo
) {
    suspend operator fun invoke(quarry: String): ImmutableList<FlowerSort> {
        if (quarry.isBlank() || quarry.length < 3) return persistentListOf()
        return repo.flowerSearch(quarry)
            .sortedWith(
                compareBy<FlowerSort> { it.name.startsWith(quarry) && it.abr?.startsWith(quarry) == true }
                    .thenByDescending { it.active }
                    .thenByDescending { it.purchasePercent ?: 0.0 })
            .map {
                it.copy(
                    imgUrl = it.imgUrl.replaceHttp(),
                    smallImgUrl = it.smallImgUrl.replaceHttp()
                )
            }
            .toImmutableList()
    }
}