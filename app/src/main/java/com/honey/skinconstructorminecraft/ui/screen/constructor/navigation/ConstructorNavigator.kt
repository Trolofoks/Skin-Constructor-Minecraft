package com.honey.skinconstructorminecraft.ui.navigation.navigator

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.honey.skinconstructorminecraft.ui.screen.constructor.ConstructorRoute

const val constructorRoute = "constructor_route"

fun NavController.navigateToConstructor(navOptions: NavOptions? = null){
    this.navigate(constructorRoute)
}

fun NavGraphBuilder.constructorScreen(onTestClick: ()-> Unit){
    composable(route = constructorRoute){
        ConstructorRoute(onTestClick = onTestClick)
    }
}