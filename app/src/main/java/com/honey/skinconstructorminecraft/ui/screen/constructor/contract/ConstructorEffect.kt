package com.honey.skinconstructorminecraft.ui.screen.constructor.contract

import com.honey.skinconstructorminecraft.base.ViewEffect

sealed class ConstructorEffect: ViewEffect{
    data class OnTitleSet(val titleId: Int): ConstructorEffect()
}
