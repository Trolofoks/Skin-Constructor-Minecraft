package com.honey.skinconstructorminecraft.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.honey.skinconstructorminecraft.R

enum class Category(
    @DrawableRes val imageId: Int,
    @StringRes val textId: Int
    ) {

    HEAD(
        imageId = R.drawable.ic_launcher_foreground,
        textId = R.string.head
    ),

    BODY(
        imageId = R.drawable.ic_launcher_foreground,
        textId = R.string.body
    ),

    LEGS(
    imageId = R.drawable.ic_launcher_foreground,
    textId = R.string.legs
    )
}