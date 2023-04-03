package com.aruzeta.tmdb.ui.screen.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aruzeta.tmdb.ui.utils.Destination

inline fun <T : ViewModel> NavGraphBuilder.screen(
    destination: Destination,
    crossinline topAppBar: @Composable (T) -> Unit,
    crossinline content: @Composable (T, PaddingValues) -> Unit,
    crossinline viewModelFn: @Composable () -> T,
) = composable(
    route = destination.route,
    arguments = destination.arguments,
) {
    val viewModel = viewModelFn()
    Scaffold(
        topBar = { topAppBar(viewModel) },
        content = { padding -> content(viewModel, padding) }
    )
}

inline fun <T : ViewModel> NavGraphBuilder.screen(
    destination: Destination,
    crossinline topAppBar: @Composable (T) -> Unit,
    crossinline bottomAppBar: @Composable (T) -> Unit,
    crossinline content: @Composable (T, PaddingValues) -> Unit,
    crossinline viewModelFn: @Composable () -> T,
) = composable(
    route = destination.route,
    arguments = destination.arguments,
) {
    val viewModel = viewModelFn()
    Scaffold(
        topBar = { topAppBar(viewModel) },
        bottomBar = { bottomAppBar(viewModel) },
        content = { padding -> content(viewModel, padding) }
    )
}
