package com.daoflowers.catalog.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlowerSize(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("flowerTypeId")
    val flowerTypeId: Int? = null,
    @SerialName("position")
    val position: Int? = null,
    @SerialName("isMix")
    val isMix: Boolean? = null,
    @SerialName("active")
    val active: Boolean? = null
)