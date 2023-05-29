package com.honey.skinconstructorminecraft.ui.screen.constructor.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val constructorRoute = "constructor_route"

fun NavController.navigateToConstructor(navOptions: NavOptions? = null){
    this.navigate(constructorRoute)
}

fun NavGraphBuilder.constructorScreen(onTestClick: () -> Unit, onTitleSet: (stringId: Int) -> Unit){
    composable(route = constructorRoute){
        ConstructorRoute(onTestClick = onTestClick, onTitleSet = onTitleSet)
    }
}