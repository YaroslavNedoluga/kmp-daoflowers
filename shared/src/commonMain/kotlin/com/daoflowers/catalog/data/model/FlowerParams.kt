package com.daoflowers.catalog.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlowerParams(
    @SerialName("flowerTypes")
    val flowerTypes: List<FlowerType>? = null,
    @SerialName("lowerColors")
    val flowerColors: List<FlowerColor>? = null,
    @SerialName("breeders")
    val breeders: List<Breeder>? = null,
)