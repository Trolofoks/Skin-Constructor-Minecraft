package com.honey.skinconstructorminecraft.ui.screen.constructor

import com.honey.skinconstructorminecraft.base.BaseViewModel
import com.honey.skinconstructorminecraft.model.AppCategory
import com.honey.domain.model.SkinItem
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorEffect
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorEvent
import com.honey.skinconstructorminecraft.ui.screen.constructor.contract.ConstructorState

class ConstructorViewModel : BaseViewModel<ConstructorEvent, ConstructorState, ConstructorEffect>(
    initialState = ConstructorState.Loading
) {
    init {
        viewState = ConstructorState.Showing(
            items = emptyList(),
            selectedCategory = AppCategory.HEAD,
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

    private fun performSelectCategory(category: AppCategory, state: ConstructorState.Showing){
        viewState = state.copy(selectedCategory = category)
        effect = ConstructorEffect.OnTitleSet(category.textId)
    }
}