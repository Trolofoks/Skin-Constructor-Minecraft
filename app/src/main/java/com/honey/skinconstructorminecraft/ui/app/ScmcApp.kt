package com.honey.skinconstructorminecraft.ui.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.honey.skinconstructorminecraft.ui.navigation.ScmcNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScmcApp(
    appState: ScmcAppState = rememberScmcAppState()
) {
    Scaffold {padding->
        ScmcNavHost(navController = appState.navController, modifier = Modifier.padding(padding))
    }
}