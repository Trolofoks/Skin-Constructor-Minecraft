package com.honey.domain.model


data class SkinItem(
    val priorityLayer: Int = 0,
    val skinItemId: Int,
    val itemDescId: Int,
    val category: Category
)
