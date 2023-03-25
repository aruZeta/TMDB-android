package com.aruzeta.tmdb.api.tmdb

import com.aruzeta.tmdb.model.tmdb.api.TmdbApiRoute
import com.aruzeta.tmdb.model.tmdb.data.TrendingList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TmdbApi {
    @GET("trending/{mediaType}/{timeWindow}")
    @InjectAuth
    suspend fun getTrending(
        @Path("mediaType") mediaType: TmdbApiRoute.MediaType,
        @Path("timeWindow") timeWindow: TmdbApiRoute.TimeWindow,
    ): Response<TrendingList>
}

const val TMDB_API_URL = "https://api.themoviedb.org/3/"
