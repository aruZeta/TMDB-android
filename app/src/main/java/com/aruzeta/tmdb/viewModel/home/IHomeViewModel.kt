package com.aruzeta.tmdb.viewModel.home

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.aruzeta.tmdb.model.tmdb.data.Movie
import com.aruzeta.tmdb.ui.utils.UiState
import com.aruzeta.tmdb.viewModel.utils.ILoading
import com.aruzeta.tmdb.viewModel.utils.IUiEvent
import kotlinx.coroutines.flow.StateFlow

interface IHomeViewModel : ILoading, IUiEvent {
    val trendingFilms: SnapshotStateList<Movie>
}
