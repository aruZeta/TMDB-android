package com.aruzeta.tmdb.ui.utils

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.aruzeta.tmdb.model.tmdb.data.Movie
import com.aruzeta.tmdb.viewModel.home.HomeViewModel
import com.aruzeta.tmdb.viewModel.home.IHomeViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow

object Previews {
    object Model {
        val movie = Movie.MinimumData(
            id = 0,
            title = "Interstellar",
            imagePath = "",
        )
    }

    @Suppress("ObjectPropertyName")
    @OptIn(DelicateCoroutinesApi::class)
    object ViewModel {
        val HomeViewModel = object : IHomeViewModel {
            override val trendingFilms: SnapshotStateList<Movie.MinimumData> =
                mutableStateListOf(*Array(5) { Model.movie })

            private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
            override val uiState: StateFlow<UiState> = _uiState

            private val _uiEvent = Channel<UiEvent>()
            override val uiEvent: Flow<UiEvent> = _uiEvent.receiveAsFlow()

            init {
                GlobalScope.launch {
                    delay(2_000)
                    _uiState.value = UiState.Success
                }
            }
        }
    }
}
