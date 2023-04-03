package com.aruzeta.tmdb.viewModel.utils

import com.aruzeta.tmdb.ui.utils.UiState
import kotlinx.coroutines.flow.StateFlow

interface ILoading {
    val uiState: StateFlow<UiState>
}
