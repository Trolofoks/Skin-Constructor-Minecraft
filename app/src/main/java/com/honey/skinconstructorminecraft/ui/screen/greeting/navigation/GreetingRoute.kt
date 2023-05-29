package com.honey.skinconstructorminecraft.ui.screen.greeting

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.androidx.compose.getViewModel

@Composable
fun GreetingRoute(
    onConstructorClick: () -> Unit,
    onTitleSet: (stringId: Int) -> Unit
) {
    val viewModel = getViewModel<GreetingViewModel>()
    GreetingScreen(
        state = viewModel.getViewState().collectAsState(),
        effect = viewModel.getEffect(),
        onEventSend = {event -> viewModel.obtainEvent(event)},
        onConstructorClick = onConstructorClick,
        onTitleSet = onTitleSet
    )
}