package com.honey.skinconstructorminecraft.ui.screen.constructor.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.honey.skinconstructorminecraft.ui.screen.constructor.ConstructorScreen
import com.honey.skinconstructorminecraft.ui.screen.constructor.ConstructorViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ConstructorRoute(
    onTestClick: () -> Unit,
    onTitleSet : (stringRes: Int) -> Unit
) {
    val viewModel = getViewModel<ConstructorViewModel>()
    ConstructorScreen(
        state = viewModel.getViewState().collectAsState(),
        effect = viewModel.getEffect(),
        onEventSend = {event -> viewModel.obtainEvent(event) },
        onTestClick = onTestClick,
        onTitleSet = onTitleSet,
    )
}