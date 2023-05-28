package com.honey.skinconstructorminecraft.ui.screen.constructor.contract

import com.honey.skinconstructorminecraft.base.ViewState
import com.honey.skinconstructorminecraft.data.Category
import com.honey.skinconstructorminecraft.data.SkinItem

sealed class ConstructorState : ViewState {
    object Loading: ConstructorState()
    data class Showing(
        val items: List<SkinItem>,
        val selectedCategory: Category = Category.HEAD,
        val selectedItem: SkinItem? = null
        ) : ConstructorState()
}