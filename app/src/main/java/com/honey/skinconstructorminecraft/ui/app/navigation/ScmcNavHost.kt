package com.honey.skinconstructorminecraft.ui.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.honey.skinconstructorminecraft.ui.screen.constructor.navigation.constructorRoute
import com.honey.skinconstructorminecraft.ui.screen.constructor.navigation.constructorScreen
import com.honey.skinconstructorminecraft.ui.screen.greeting.navigation.greetingRoute
import com.honey.skinconstructorminecraft.ui.screen.greeting.navigation.greetingScreen

@Composable
fun ScmcNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = greetingRoute,
    onTitleSet: (stringId: Int) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        greetingScreen(
            onConstructorClick = {
                navController.navigate(route = constructorRoute)
            } ,
            onTitleSet = onTitleSet
        )
        constructorScreen(
            onTestClick = {},
            onTitleSet = onTitleSet
        )
    }
}