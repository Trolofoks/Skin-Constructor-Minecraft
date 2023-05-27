package com.honey.skinconstructorminecraft.ui.navigation

import com.honey.skinconstructorminecraft.R

enum class TopLevelDestination(
    val titleTextId : Int
) {
    GREETING(
        titleTextId = R.string.app_name
    ),
    CONSTRUCTOR(
        titleTextId = R.string.constructor
    )
}