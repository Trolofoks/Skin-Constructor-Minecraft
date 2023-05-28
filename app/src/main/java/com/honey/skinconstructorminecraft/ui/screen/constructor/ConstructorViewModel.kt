package com.honey.skinconstructorminecraft.ui.screen.constructor

import androidx.lifecycle.ViewModel
import com.honey.skinconstructorminecraft.base.BaseViewModel
import com.honey.skinconstructorminecraft.data.Category
import com.honey.skinconstructorminecraft.data.SkinItem
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorEvent
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorState

class ConstructorViewModel : BaseViewModel<ConstructorEvent, ConstructorState>(
    initialState = ConstructorState.Loading
) {
    init {
        viewState = ConstructorState.Showing(
            items = emptyList(),
            selectedCategory = Category.HEAD,
            selectedItem = null
        )
    }

    override fun obtainEvent(event: ConstructorEvent) {
        when(val state = viewState){
            is ConstructorState.Loading -> {reduce(event,state)}
            is ConstructorState.Showing -> {reduce(event,state)}
        }
    }

    private fun reduce(event: ConstructorEvent, state: ConstructorState.Loading){

    }

    private fun reduce(event: ConstructorEvent, state: ConstructorState.Showing) {
        when (event){
            is ConstructorEvent.SelectItem -> {performSelectItem(event.item,state)}
            is ConstructorEvent.SelectCategory -> {performSelectCategory(event.category,state)}
            else -> {}
        }
    }

    private fun performSelectItem(item: SkinItem, state: ConstructorState.Showing){
        viewState = state.copy(selectedItem = item)
    }

    private fun performSelectCategory(category: Category, state: ConstructorState.Showing){
        viewState = state.copy(selectedCategory = category)
    }
}