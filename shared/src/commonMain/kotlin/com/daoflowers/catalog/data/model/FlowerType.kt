package com.daoflowers.catalog.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlowerType(
    @SerialName("id")
    val id: Int,
    @SerialName("isGroup")
    val isGroup: Boolean,
    @SerialName("flowerTypeGroupId")
    val groupId: Int? = null,
    @SerialName("name")
    val name: String,
    @SerialName("shortName")
    val shortName: String? = null,
    @SerialName("abr")
    val abr: String?,
    @SerialName("imgUrl")
    val imgUrl: String? = null,
    @SerialName("sortsCount")
    val sortsCount: Int? = null,
    @SerialName("imagesCount")
    val imagesCount: Int? = null,
    @SerialName("position")
    val position: Int
)