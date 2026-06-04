package com.balzaneli.verolist.ui

sealed interface UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent
    data object NavigationBack : UiEvent
    data class Navigate<T : Any>(val route: T) : UiEvent
}