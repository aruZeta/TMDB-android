@file:Suppress("NOTHING_TO_INLINE")

package com.aruzeta.tmdb.ui.screen.homeScreen

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.aruzeta.tmdb.ui.topAppBar.common.defaultTopAppBarColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
inline fun HomeScreenTopAppBar(
) = TopAppBar(
    title = { Text(text = "Trending movies") },
    colors = defaultTopAppBarColors(),
    actions = {},
)
