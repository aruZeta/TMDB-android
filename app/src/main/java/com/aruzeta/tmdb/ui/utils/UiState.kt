package com.aruzeta.tmdb.ui.utils

sealed interface UiState {
    object Loading : UiState
    object Success : UiState
    object Error : UiState
}
