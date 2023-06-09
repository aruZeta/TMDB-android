package com.aruzeta.tmdb.ui.utils

import androidx.navigation.NamedNavArgument

sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList(),
) {
    object HomeScreen : Destination("home")
}

fun Destination.HomeScreen.genRoute(
) = route.toRoute()

@Suppress("NOTHING_TO_INLINE")
private inline fun String.toRoute(): Route = Route(this)
