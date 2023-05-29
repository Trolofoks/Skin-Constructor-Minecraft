package com.honey.skinconstructorminecraft.ui.app

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.honey.skinconstructorminecraft.R
import com.honey.skinconstructorminecraft.ui.app.navigation.ScmcNavHost
import com.honey.skinconstructorminecraft.ui.app.navigation.TopLevelDestination
import com.honey.skinconstructorminecraft.ui.part.ScmcDropDownMenu
import com.honey.skinconstructorminecraft.ui.part.ScmcTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScmcApp(
    appState: ScmcAppState = rememberScmcAppState()
) {
    val titleName = remember { mutableStateOf<Int?>(null) }
    val menuOpened = remember { mutableStateOf(false)}
    val menuButtonVisibility = (appState.currentTopLevelDestination == TopLevelDestination.CONSTRUCTOR)

    Scaffold(
        topBar = {
            ScmcTopAppBar(
                titleNameState = titleName.value?: appState.currentTopLevelDestination?.titleTextId?:R.string.loading,
                menuOpenedState = menuOpened,
                menuButtonVisibility = menuButtonVisibility,
                onMenuClick = {menuOpened.value = !menuOpened.value}
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)){

            ScmcNavHost(
                navController = appState.navController,
                onTitleSet = {stringId->
                    titleName.value = stringId
                }
            )

            if (menuOpened.value){
                ScmcDropDownMenu(modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(10.dp),
                    onItemClick = {

                    }
                )
            }
        }
    }
}