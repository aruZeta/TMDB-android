package com.aruzeta.tmdb.model.tmdb.api

sealed class TimeWindow(
    val route: String,
) {
    object Day : TimeWindow("day")
    object Week : TimeWindow("week")

    override fun toString(): String = route
}
