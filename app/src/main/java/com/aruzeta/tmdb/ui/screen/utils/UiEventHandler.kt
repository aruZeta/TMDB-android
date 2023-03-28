@file:Suppress("NOTHING_TO_INLINE")

package com.aruzeta.tmdb.ui.screen.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.aruzeta.tmdb.ui.utils.UiEvent
import com.aruzeta.tmdb.viewModel.utils.IUiEvent

@Composable
inline fun UiEventHandler(
    viewModel: IUiEvent,
    navController: NavHostController,
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> { }
                is UiEvent.Navigate ->
                    navController.navigate(event.route.route)
                is UiEvent.PopBackStack ->
                    navController.popBackStack()
            }
        }
    }

}
