package com.honey.skinconstructorminecraft.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.honey.skinconstructorminecraft.ui.navigation.navigator.constructorRoute
import com.honey.skinconstructorminecraft.ui.navigation.navigator.constructorScreen
import com.honey.skinconstructorminecraft.ui.screen.greeting.navigation.greetingRoute
import com.honey.skinconstructorminecraft.ui.screen.greeting.navigation.greetingScreen

@Composable
fun ScmcNavHost(
    navController: NavHostController,
    modifier: Modifier,
    startDestination: String = greetingRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        greetingScreen(onConstructorClick = {
            navController.navigate(route = constructorRoute)
        })
        constructorScreen(onTestClick = {})
    }
}