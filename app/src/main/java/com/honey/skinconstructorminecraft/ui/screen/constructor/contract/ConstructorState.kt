package com.honey.skinconstructorminecraft.ui.screen.constructor.contract

import com.honey.skinconstructorminecraft.base.ViewState
import com.honey.skinconstructorminecraft.model.AppCategory
import com.honey.domain.model.SkinItem

sealed class ConstructorState : ViewState {
    object Loading: ConstructorState()
    data class Showing(
        val items: List<SkinItem>,
        val selectedCategory: AppCategory = AppCategory.HEAD,
        val selectedItem: SkinItem? = null
        ) : ConstructorState()
}