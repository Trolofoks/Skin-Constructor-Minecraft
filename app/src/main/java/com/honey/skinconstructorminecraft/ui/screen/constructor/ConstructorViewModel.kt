package com.honey.skinconstructorminecraft.ui.screen.constructor

import androidx.lifecycle.ViewModel
import com.honey.skinconstructorminecraft.base.BaseViewModel
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorEvent
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorState

class ConstructorViewModel : BaseViewModel<ConstructorEvent, ConstructorState>(
    initialState = ConstructorState.Loading
) {
    override fun obtainEvent(event: ConstructorEvent) {
        when(val state = viewState){
            is ConstructorState.Loading -> {reduce(event,state)}
        }
    }

    private fun reduce(event: ConstructorEvent, state: ConstructorState.Loading){

    }
}