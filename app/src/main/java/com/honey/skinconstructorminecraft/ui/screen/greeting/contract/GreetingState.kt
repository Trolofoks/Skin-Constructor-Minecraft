package com.honey.skinconstructorminecraft.ui.screen.greeting.contract

import com.honey.skinconstructorminecraft.base.ViewState

sealed class GreetingState : ViewState {
    object Loading: GreetingState()
}