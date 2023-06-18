package com.daoflowers.catalog.data.model

import kotlinx.serialization.Serializable

@Serializable
data class FlowerSearchRequest(
    val nameOrAbr: String = "",
    val flowerTypeIds: List<Int>? = null,
    val flowerColorIds: List<Int>? = null,
    val breederIds: List<Int>? = null,
)