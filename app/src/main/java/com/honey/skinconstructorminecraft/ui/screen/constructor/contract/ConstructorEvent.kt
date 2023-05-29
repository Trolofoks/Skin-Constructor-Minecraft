package com.honey.skinconstructorminecraft.ui.screen.constructor.contract

import com.honey.skinconstructorminecraft.base.ViewEvent
import com.honey.skinconstructorminecraft.model.AppCategory
import com.honey.domain.model.SkinItem

sealed class ConstructorEvent : ViewEvent {
    data class SelectCategory(val category: AppCategory) : ConstructorEvent()
    data class SelectItem(val item: SkinItem): ConstructorEvent()
}