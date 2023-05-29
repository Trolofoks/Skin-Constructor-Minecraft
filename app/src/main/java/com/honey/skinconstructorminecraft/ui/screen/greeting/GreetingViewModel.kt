package com.honey.skinconstructorminecraft.ui.screen.greeting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.honey.skinconstructorminecraft.R
import com.honey.skinconstructorminecraft.base.BaseViewModel
import com.honey.skinconstructorminecraft.ui.screen.greeting.contract.GreetingEffect
import com.honey.skinconstructorminecraft.ui.screen.greeting.contract.GreetingEvent
import com.honey.skinconstructorminecraft.ui.screen.greeting.contract.GreetingState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GreetingViewModel : BaseViewModel<GreetingEvent, GreetingState, GreetingEffect>(
    initialState = GreetingState.Loading
) {
    init {
        viewState = GreetingState.Show

    }
    override fun obtainEvent(event: GreetingEvent) {
        when(val state = viewState){
            is GreetingState.Loading -> {reduce(event, state)}
            is GreetingState.Show -> {reduce(event,state)}
            else -> {}
        }
    }

    private fun reduce(event: GreetingEvent, state: GreetingState.Loading){

    }

    private fun reduce(event: GreetingEvent, state: GreetingState.Show) {

    }
}