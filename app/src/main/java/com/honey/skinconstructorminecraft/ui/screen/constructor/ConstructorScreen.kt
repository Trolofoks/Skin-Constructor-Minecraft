package com.honey.skinconstructorminecraft.ui.screen.constructor

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorEffect
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorEvent
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorState
import com.honey.skinconstructorminecraft.ui.screen.constructor.view.ConstructorMainView
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun ConstructorScreen(
    state: State<ConstructorState>,
    effect: SharedFlow<ConstructorEffect?>,
    onEventSend: (event: ConstructorEvent) -> Unit,
    onTestClick: () -> Unit,
    onTitleSet: (stringRes: Int) -> Unit
) {
    val coroutine = rememberCoroutineScope()
    when(val state = state.value){
        is ConstructorState.Loading -> {}
        is ConstructorState.Showing -> {
            ConstructorMainView(
                state = state,
                onSelectCategory = {category->
                    onEventSend.invoke(ConstructorEvent.SelectCategory(category))
                },
                onSelectItem = {item->
                    onEventSend.invoke(ConstructorEvent.SelectItem(item))
                }
            )
        }
    }
    SideEffect {
        coroutine.launch {
            effect.collect(){effect ->
                when(effect){
                    is ConstructorEffect.OnTitleSet -> {
                        onTitleSet.invoke(effect.titleId)
                    }
                    else -> {}
                }
            }
        }
    }
}