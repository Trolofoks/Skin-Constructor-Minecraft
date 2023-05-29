package com.honey.skinconstructorminecraft.ui.screen.greeting.contract

import com.honey.skinconstructorminecraft.base.ViewEvent

sealed class GreetingEvent : ViewEvent {
    object DuckClick : GreetingEvent()
}