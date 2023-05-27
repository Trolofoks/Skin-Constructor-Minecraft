package com.honey.skinconstructorminecraft.ui.screen.constructor.contract

import com.honey.skinconstructorminecraft.base.ViewState

sealed class ConstructorState : ViewState {
    object Loading: ConstructorState()
}