package com.honey.skinconstructorminecraft.ui.screen.constructor

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.androidx.compose.getViewModel

@Composable
fun ConstructorRoute(
    onTestClick: () -> Unit
) {
    val viewModel = getViewModel<ConstructorViewModel>()
    ConstructorScreen(
        state = viewModel.getViewState().collectAsState(),
        onEventSend = {event -> viewModel.obtainEvent(event) },
        onTestClick = onTestClick
    )
}