package com.honey.skinconstructorminecraft.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface ViewEvent
interface ViewState

abstract class BaseViewModel<Event: ViewEvent, UiState: ViewState>(initialState: UiState):ViewModel() {
    abstract fun obtainEvent(event: Event)

    private val _viewState = MutableStateFlow<UiState>(initialState)
    protected var viewState: UiState
        get() = _viewState.value
        set(value) {_viewState.value = value}

    fun getViewState() : StateFlow<UiState> = _viewState.asStateFlow()
}