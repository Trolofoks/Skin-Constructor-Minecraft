package com.honey.skinconstructorminecraft.data

import com.honey.skinconstructorminecraft.R

data class SkinItem(
    val skinItemId: Int = R.drawable.ic_launcher_foreground,
    val priorityLayer: Int = 0,
    val category: Category = Category.HEAD,
    val itemDescId: Int = R.string.app_name
)
