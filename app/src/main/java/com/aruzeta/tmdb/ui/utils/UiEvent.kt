package com.aruzeta.tmdb.ui.utils

sealed interface UiEvent {
    object PopBackStack : UiEvent

    data class Navigate(
        val route: Route,
    ) : UiEvent

    data class ShowSnackbar(
        val message: String,
        val action: String? = null,
    ) : UiEvent
}
