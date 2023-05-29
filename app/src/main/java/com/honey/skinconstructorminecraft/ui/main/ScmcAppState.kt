package com.honey.skinconstructorminecraft.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.honey.skinconstructorminecraft.ui.main.navigation.TopLevelDestination
import com.honey.skinconstructorminecraft.ui.screen.constructor.navigation.constructorRoute
import com.honey.skinconstructorminecraft.ui.screen.greeting.navigation.greetingRoute
import com.honey.skinconstructorminecraft.ui.screen.constructor.navigation.navigateToConstructor
import com.honey.skinconstructorminecraft.ui.screen.greeting.navigation.navigateToGreeting
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberScmcAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): ScmcAppState{
    return remember(coroutineScope,navController){
        ScmcAppState(coroutineScope,navController)
    }

}

class ScmcAppState(
    val coroutineScope: CoroutineScope,
    val navController: NavHostController
) {


    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when(currentDestination?.route){
            greetingRoute -> TopLevelDestination.GREETING
            constructorRoute -> TopLevelDestination.CONSTRUCTOR
            else -> null
        }

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination){
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
        when (topLevelDestination){
            TopLevelDestination.GREETING -> navController.navigateToGreeting(topLevelNavOptions)
            TopLevelDestination.CONSTRUCTOR -> navController.navigateToConstructor(topLevelNavOptions)
        }
    }
}