@file:Suppress("NOTHING_TO_INLINE")

package com.aruzeta.tmdb.ui.screen.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aruzeta.tmdb.model.tmdb.data.Movie
import com.aruzeta.tmdb.ui.screen.utils.LoadingContent
import com.aruzeta.tmdb.ui.utils.Previews
import com.aruzeta.tmdb.viewModel.home.IHomeViewModel

@Composable
fun HomeScreenContent(
    modifier: Modifier,
    viewModel: IHomeViewModel,
) = LoadingContent(
    modifier = modifier,
    viewModel = viewModel,
    loadingText = "Loading trending films",
    successScreen = { MovieList(modifier = modifier, viewModel = viewModel) },
    errorScreen = { Text(text = "Error loading trending films") }
)

@Composable
private inline fun MovieList(
    modifier: Modifier,
    viewModel: IHomeViewModel,
) {
    val movies = remember { viewModel.trendingFilms }
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        content = { items(movies) { MovieCard(movie = it) } }
    )
}

@Composable
private inline fun MovieCard(
    movie: Movie,
) = Surface(
    modifier = Modifier.fillMaxWidth(),
    shape = RoundedCornerShape(10.dp),
    color = MaterialTheme.colorScheme.primaryContainer,
    onClick = {  },
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(10.dp),
    ) {
        Text(text = movie.title)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "${movie.id}")
    }
}

// Previews

@Composable
@Preview(showBackground = true)
private fun MovieCardPreview() = MovieCard(movie = Previews.Model.movie)
