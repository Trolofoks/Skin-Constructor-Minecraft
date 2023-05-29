package com.honey.skinconstructorminecraft.ui.screen.greeting

import androidx.compose.runtime.*
import com.honey.skinconstructorminecraft.ui.screen.greeting.contract.GreetingEffect
import com.honey.skinconstructorminecraft.ui.screen.greeting.contract.GreetingEvent
import com.honey.skinconstructorminecraft.ui.screen.greeting.contract.GreetingState
import com.honey.skinconstructorminecraft.ui.screen.greeting.view.GreetingLoadingView
import com.honey.skinconstructorminecraft.ui.screen.greeting.view.GreetingShowView
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun GreetingScreen(
    state: State<GreetingState>,
    effect: SharedFlow<GreetingEffect?>,
    onEventSend: (event: GreetingEvent) -> Unit,
    onConstructorClick: () -> Unit,
    onTitleSet: (stringRes: Int) -> Unit
) {
    val coroutine = rememberCoroutineScope()
    when(val state = state.value){
        is GreetingState.Loading -> {
            GreetingLoadingView(state = state)
        }
        is GreetingState.Show -> {
            GreetingShowView(state = state, navigateToConstructor = onConstructorClick)
        }
    }
    SideEffect() {
        coroutine.launch{
            effect.collect(){effect->
                when(effect){
                    is GreetingEffect.OnTitleSet -> {
                        onTitleSet.invoke(effect.titleId)
                    }
                    else -> {}
                }

            }
        }
    }


}