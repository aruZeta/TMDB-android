package com.aruzeta.tmdb.model.tmdb.api

import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

sealed interface TmdbApiRoute {
    val route: String

    sealed class MediaType(override val route: String) : TmdbApiRoute {
        object All : MediaType("all")
        object Movie : MediaType("movie")
        object TV : MediaType("tv")
        object Person : MediaType("person")
    }

    sealed class TimeWindow(override val route: String) : TmdbApiRoute {
        object Day : TimeWindow("day")
        object Week : TimeWindow("week")
    }
}

class TmdbApiRouteConverter : Converter<TmdbApiRoute, String> {
    override fun convert(value: TmdbApiRoute): String = value.route
}

class TmdbApiRouteConverterFactory : Converter.Factory() {
    override fun stringConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<TmdbApiRoute, String> = TmdbApiRouteConverter()
}
