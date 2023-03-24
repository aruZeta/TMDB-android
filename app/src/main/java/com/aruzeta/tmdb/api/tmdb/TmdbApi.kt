package com.aruzeta.tmdb.api.tmdb

import com.aruzeta.tmdb.model.tmdb.api.MediaType
import com.aruzeta.tmdb.model.tmdb.api.TimeWindow
import com.aruzeta.tmdb.model.tmdb.data.TrendingList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TmdbApi {
    @GET("trending/{mediaType}/{timeWindow}")
    suspend fun getTrending(
        @Path("mediaType") mediaType: MediaType,
        @Path("timeWindow") timeWindow: TimeWindow,
    ): Response<TrendingList>
}

const val TMDB_API_URL = "https://api.themoviedb.org/3/"
