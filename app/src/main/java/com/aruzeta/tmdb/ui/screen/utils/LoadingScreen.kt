@file:Suppress("NOTHING_TO_INLINE")

package com.aruzeta.tmdb.ui.screen.utils

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aruzeta.tmdb.ui.utils.UiState
import com.aruzeta.tmdb.viewModel.utils.ILoading

@Composable
@OptIn(ExperimentalAnimationApi::class)
fun LoadingContent(
    modifier: Modifier,
    viewModel: ILoading,
    loadingText: String,
    successScreen: @Composable () -> Unit,
    errorScreen: @Composable () -> Unit,
) {
    val state by viewModel.uiState.collectAsState()
    AnimatedContent(
        targetState = state,
        transitionSpec = { loadingTransition() }
    ) {
        when (it) {
            UiState.Loading -> ShowLoadingIndicator(modifier = modifier, loadingText)
            UiState.Success -> successScreen()
            UiState.Error -> errorScreen()
        }

    }
}

@OptIn(ExperimentalAnimationApi::class)
private inline fun loadingTransition() =
    fadeIn(animationSpec = tween(100, delayMillis = 50)) +
            scaleIn(initialScale = 0.90f, animationSpec = tween(200, delayMillis = 50)) with
            fadeOut(animationSpec = tween(100))

@Composable
private inline fun ShowLoadingIndicator(
    modifier: Modifier,
    text: String,
) = Column(
    modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
    verticalArrangement = Arrangement.spacedBy(
        space = 5.dp,
        alignment = Alignment.CenterVertically,
    ),
    horizontalAlignment = Alignment.CenterHorizontally,
    content = {
        CircularProgressIndicator()
        Text(text = text)
    }
)
