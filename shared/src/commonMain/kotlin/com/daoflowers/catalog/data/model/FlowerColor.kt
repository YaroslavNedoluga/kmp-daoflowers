package com.daoflowers.catalog.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlowerColor(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)