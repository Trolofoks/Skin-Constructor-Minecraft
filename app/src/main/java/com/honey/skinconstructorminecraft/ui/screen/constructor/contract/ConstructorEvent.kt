package com.honey.skinconstructorminecraft.ui.screen.constructor.contract

import com.honey.skinconstructorminecraft.base.ViewEvent
import com.honey.skinconstructorminecraft.data.Category
import com.honey.skinconstructorminecraft.data.SkinItem

sealed class ConstructorEvent : ViewEvent {
    data class SelectCategory(val category: Category) : ConstructorEvent()
    data class SelectItem(val item: SkinItem): ConstructorEvent()
}