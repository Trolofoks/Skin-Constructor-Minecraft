package com.honey.skinconstructorminecraft.ui.screen.constructor

import android.icu.util.UniversalTimeScale
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorEvent
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorState

@Composable
fun ConstructorScreen(
    state: State<ConstructorState>,
    onEventSend : (event : ConstructorEvent) -> Unit,
    onTestClick : () -> Unit
) {
    Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize().padding(32.dp)) {
        Text(text = "Hello, it's constructor. State -> ${state.value}")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Go Back")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Navigate Back")
        }
    }
}