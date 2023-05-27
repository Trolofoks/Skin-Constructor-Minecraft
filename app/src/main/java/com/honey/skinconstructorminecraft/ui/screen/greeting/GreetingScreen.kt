package com.honey.skinconstructorminecraft.ui.screen.greeting

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
import com.honey.skinconstructorminecraft.ui.screen.greeting.contract.GreetingEvent
import com.honey.skinconstructorminecraft.ui.screen.greeting.contract.GreetingState

@Composable
fun GreetingScreen(
    state: State<GreetingState>,
    onEventSend: (event: GreetingEvent) -> Unit,
    onConstructorClick: () -> Unit
) {
    Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize().padding(32.dp)) {
        Text(text = "Hello Android, It's Greeting screen")
        Button(onClick = { onConstructorClick.invoke() }) {
            Text(text = "Navigate to Constructor")
        }
    }
}