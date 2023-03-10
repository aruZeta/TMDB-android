package com.aruzeta.tmdb.ui

import androidx.navigation.NamedNavArgument

sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList(),
) {
    object FirstScreen: Destination("first")
}
