package com.aruzeta.tmdb.ui.utils

@JvmInline
value class Route(val route: String) {
    @Suppress("NOTHING_TO_INLINE")
    inline fun setParam(param: String, value: String): Route =
        apply { route.replaceFirst("{$param}", value) }
}
