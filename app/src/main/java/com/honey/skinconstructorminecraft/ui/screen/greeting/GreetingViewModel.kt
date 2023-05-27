package com.honey.skinconstructorminecraft.ui.screen.greeting

import androidx.lifecycle.ViewModel
import com.honey.skinconstructorminecraft.base.BaseViewModel
import com.honey.skinconstructorminecraft.ui.screen.greeting.contract.GreetingEvent
import com.honey.skinconstructorminecraft.ui.screen.greeting.contract.GreetingState

class GreetingViewModel : BaseViewModel<GreetingEvent, GreetingState>(
    initialState = GreetingState.Loading
) {
    override fun obtainEvent(event: GreetingEvent) {
        when(val state = viewState){
            is GreetingState.Loading -> {reduce(event, state)}
        }
    }

    private fun reduce(event: GreetingEvent, state: GreetingState.Loading){

    }
}