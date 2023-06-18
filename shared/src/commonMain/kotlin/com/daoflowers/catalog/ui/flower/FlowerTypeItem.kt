package com.daoflowers.catalog.ui.flower

data class FlowerTypeItem(
    val id: Int,
    val name: String,
    val imgUrl: String? = null,
    val sortsCount: Int,
    val imagesCount: Int,
)