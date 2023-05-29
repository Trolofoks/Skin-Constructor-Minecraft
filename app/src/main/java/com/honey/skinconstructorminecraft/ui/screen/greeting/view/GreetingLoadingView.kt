package com.honey.skinconstructorminecraft.ui.screen.greeting.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.honey.skinconstructorminecraft.ui.screen.greeting.contract.GreetingState

@Composable
fun GreetingLoadingView(
    state: GreetingState.Loading
){
    CircularProgressIndicator(modifier = Modifier.fillMaxSize())
    //TODO
}