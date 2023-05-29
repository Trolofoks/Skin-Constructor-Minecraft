package com.honey.skinconstructorminecraft.ui.screen.greeting.contract

import com.honey.skinconstructorminecraft.base.ViewEffect

sealed class GreetingEffect : ViewEffect {
    data class OnTitleSet(val titleId: Int): GreetingEffect()
}