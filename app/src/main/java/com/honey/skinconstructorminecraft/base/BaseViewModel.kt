package com.honey.skinconstructorminecraft.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

interface ViewEvent
interface ViewState
interface ViewEffect

abstract class BaseViewModel<Event: ViewEvent, UiState: ViewState, Effect: ViewEffect>(initialState: UiState):ViewModel() {
    abstract fun obtainEvent(event: Event)

    private val _viewState = MutableStateFlow<UiState>(initialState)
    protected var viewState: UiState
        get() = _viewState.value
        set(value) {_viewState.value = value}

    private val _effect = MutableSharedFlow<Effect?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    protected var effect: Effect?
        get() = _effect.replayCache.last()
        set(value) {_effect.tryEmit(value)}

    fun getEffect(): SharedFlow<Effect?> = _effect.asSharedFlow()

    fun getViewState() : StateFlow<UiState> = _viewState.asStateFlow()
}