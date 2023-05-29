package com.honey.skinconstructorminecraft.model


import com.honey.skinconstructorminecraft.R

enum class AppCategory(
     val imageId: Int,
     val textId: Int
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