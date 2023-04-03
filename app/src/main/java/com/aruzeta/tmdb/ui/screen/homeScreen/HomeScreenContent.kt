@file:Suppress("NOTHING_TO_INLINE")

package com.aruzeta.tmdb.ui.screen.homeScreen

import com.aruzeta.tmdb.R
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.aruzeta.tmdb.model.tmdb.data.Movie
import com.aruzeta.tmdb.ui.screen.utils.LoadingContent
import com.aruzeta.tmdb.ui.utils.Previews
import com.aruzeta.tmdb.ui.utils.debugPlaceholder
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
@OptIn(ExperimentalFoundationApi::class)
private inline fun MovieList(
    modifier: Modifier,
    viewModel: IHomeViewModel,
) {
    val movies = remember { viewModel.trendingFilms }
    LazyVerticalStaggeredGrid(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        columns = StaggeredGridCells.Fixed(2),
        content = { items(movies) { MovieCard(movie = it) } }
    )
}

@Composable
private inline fun MovieCard(
    movie: Movie.MinimumData,
) = Surface(
    modifier = Modifier.fillMaxSize(),
    shape = RoundedCornerShape(10.dp),
    color = MaterialTheme.colorScheme.primaryContainer,
    onClick = {  },
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp),
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/original${movie.imagePath}",
            modifier = Modifier.fillMaxWidth(),
            placeholder = debugPlaceholder(debugPreview = R.drawable.preview_poster),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = movie.title,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
        )
    }
}

// Previews

@Composable
@Preview(showBackground = true)
private fun MovieCardPreview() = MovieCard(movie = Previews.Model.movie)

@Composable
@Preview(showBackground = true)
private fun MovieListPreview() = MovieList(
    modifier = Modifier,
    viewModel = Previews.ViewModel.HomeViewModel,
)

@Composable
@Preview(showBackground = true)
fun HomeScreenContentPreview(
    modifier: Modifier = Modifier,
) = HomeScreenContent(
    modifier = modifier,
    viewModel = Previews.ViewModel.HomeViewModel,
)
