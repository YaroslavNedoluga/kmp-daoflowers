package com.daoflowers.catalog.ui.flower

import com.daoflowers.catalog.data.model.FlowerType
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

class FlowerTypeMapper {

    fun map(list: List<FlowerType>): ImmutableList<FlowerTypeItem> = list.map {
        FlowerTypeItem(
            id = it.id,
            name = it.name,
            imgUrl = it.imgUrl,
            sortsCount = it.sortsCount ?: 0,
            imagesCount = it.imagesCount ?: 0,
        )
    }.toImmutableList()
}