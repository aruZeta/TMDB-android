package com.aruzeta.tmdb.ui.utils

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList(),
) {
    object FirstScreen : Destination("first")
}

@Suppress("NOTHING_TO_INLINE")
private inline fun String.toRoute(): Route = Route(this)
