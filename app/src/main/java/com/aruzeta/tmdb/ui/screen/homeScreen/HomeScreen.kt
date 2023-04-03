package com.aruzeta.tmdb.ui.screen.homeScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.aruzeta.tmdb.ui.screen.utils.UiEventHandler
import com.aruzeta.tmdb.ui.utils.Destination
import com.aruzeta.tmdb.ui.screen.utils.screen
import com.aruzeta.tmdb.viewModel.home.HomeViewModel

@Suppress("FunctionName")
fun NavGraphBuilder.HomeScreen(
    navController: NavHostController,
) = screen(
    destination = Destination.HomeScreen,
    topAppBar = { HomeScreenTopAppBar() },
    content = { viewModel, padding ->
        UiEventHandler(
            viewModel = viewModel,
            navController = navController,
        )
        HomeScreenContent(
            modifier = Modifier.padding(padding),
            viewModel = viewModel
        )
    },
    viewModelFn = { hiltViewModel<HomeViewModel>() }
)

@Composable
@Preview(showBackground = true)
private fun HomeScreenPreview() = Scaffold(
    topBar = { HomeScreenTopAppBarPreview() },
    content = { HomeScreenContentPreview(Modifier.padding(it)) }
)
