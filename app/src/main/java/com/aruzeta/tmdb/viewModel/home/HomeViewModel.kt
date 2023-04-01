package com.aruzeta.tmdb.viewModel.home

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aruzeta.tmdb.model.tmdb.data.Movie
import com.aruzeta.tmdb.repository.tmdb.ITmdbRepository
import com.aruzeta.tmdb.ui.utils.UiEvent
import com.aruzeta.tmdb.ui.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val tmdbRepository: ITmdbRepository
) : ViewModel(), IHomeViewModel {
    private val _trendingFilms = mutableStateListOf<Movie>()
    override val trendingFilms: SnapshotStateList<Movie> = _trendingFilms

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    override val uiState = _uiState

    private val _uiEvent = Channel<UiEvent>()
    override val uiEvent = _uiEvent.receiveAsFlow()

    init {
        viewModelScope.launch {
            _trendingFilms.addAll(tmdbRepository.getTrending().results)
            _uiState.value = UiState.Success
        }
    }
}
