package com.aruzeta.tmdb.viewModel.utils

import com.aruzeta.tmdb.ui.utils.UiEvent
import kotlinx.coroutines.flow.Flow

interface IUiEvent {
    val uiEvent: Flow<UiEvent>
}
