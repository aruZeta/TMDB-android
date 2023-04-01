package com.aruzeta.tmdb.viewModel.home

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.aruzeta.tmdb.model.tmdb.data.Movie
import com.aruzeta.tmdb.viewModel.utils.ILoading
import com.aruzeta.tmdb.viewModel.utils.IUiEvent

interface IHomeViewModel : ILoading, IUiEvent {
    val trendingFilms: SnapshotStateList<Movie.MinimumData>
}
