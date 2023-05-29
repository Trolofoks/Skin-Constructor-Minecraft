package com.honey.skinconstructorminecraft.ui.screen.greeting.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.honey.skinconstructorminecraft.ui.screen.greeting.GreetingRoute

const val greetingRoute = "greeting_route"

fun NavController.navigateToGreeting(navOptions: NavOptions? = null){
    this.navigate(greetingRoute)
}

fun NavGraphBuilder.greetingScreen(
    onConstructorClick: () -> Unit,
    onTitleSet: (stringId: Int) -> Unit
){
    composable(route = greetingRoute){
        GreetingRoute (
            onConstructorClick = onConstructorClick,
            onTitleSet = onTitleSet

        )
    }
}