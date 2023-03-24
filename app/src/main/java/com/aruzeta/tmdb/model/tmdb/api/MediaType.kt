package com.aruzeta.tmdb.model.tmdb.api

sealed class MediaType(
    val route: String,
) {
    object All : MediaType("all")
    object Movie : MediaType("movie")
    object TV : MediaType("tv")
    object Person : MediaType("person")

    override fun toString(): String = route
}
