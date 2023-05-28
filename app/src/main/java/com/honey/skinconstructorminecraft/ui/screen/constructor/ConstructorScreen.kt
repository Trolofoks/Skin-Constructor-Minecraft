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
import com.honey.skinconstructorminecraft.ui.screen.constructor.view.ConstructorMainView

@Composable
fun ConstructorScreen(
    state: State<ConstructorState>,
    onEventSend : (event : ConstructorEvent) -> Unit,
    onTestClick : () -> Unit
) {
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
}