package com.daoflowers.catalog.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlowerSort(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("abr")
    val abr: String? = null,
    @SerialName("flowerType")
    val flowerType: FlowerType,
    @SerialName("color")
    val color: FlowerColor,
    @SerialName("sizeFrom")
    val sizeFrom: FlowerSize? = null,
    @SerialName("sizeTo")
    val sizeTo: FlowerSize? = null,
    @SerialName("imgUrl")
    val imgUrl: String? = null,
    @SerialName("smallImgUrl")
    val smallImgUrl: String? = null,
    @SerialName("mix")
    val mix: Boolean,
    @SerialName("specialMix")
    val specialMix: Boolean,
    @SerialName("purchasePercent")
    val purchasePercent: Double? = null,
    @SerialName("purchasePercentPerFlowerType")
    val purchasePercentPerFlowerType: Double? = null,
    @SerialName("fulfillment")
    val fulfillment: Double? = null,
    @SerialName("active")
    val active: Boolean
)