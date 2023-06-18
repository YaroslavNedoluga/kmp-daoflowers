package com.daoflowers.catalog.ui.flower.search

data class FlowerSearchItem(
    val id: String,
    val name: String,
    val image: String? = null,
    val size: String,
)