package com.honey.skinconstructorminecraft.ui.screen.constructor.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorState

@Composable
fun ConstructorLoadingView(
    state : ConstructorState.Loading
) {
    CircularProgressIndicator(modifier = Modifier.fillMaxSize())
}