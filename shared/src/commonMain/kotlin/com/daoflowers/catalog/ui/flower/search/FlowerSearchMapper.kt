package com.daoflowers.catalog.ui.flower.search

import com.daoflowers.catalog.data.model.FlowerSort
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

class FlowerSearchMapper {

    fun map(list: List<FlowerSort>): ImmutableList<FlowerSearchItem> =
        list.mapIndexed { index, sort ->
            FlowerSearchItem(
                id = index.toString(),
                name = sort.name,
                image = sort.smallImgUrl ?: sort.imgUrl,
                size = sort.size(),
            )
        }.toImmutableList()

    private fun FlowerSort.size(): String {
        val sizeFromName = sizeFrom?.name.orEmpty()
        val sizeToName = sizeTo?.name.orEmpty()

        if (sizeFromName == sizeToName) {
            return sizeFromName
        }

        val size = StringBuilder()
        if (sizeFromName.isNotBlank() && sizeToName.isNotBlank()) {
            size.append(sizeFromName)
            size.append(" - ")
            size.append(sizeToName)
        }

        return size.toString()
    }
}