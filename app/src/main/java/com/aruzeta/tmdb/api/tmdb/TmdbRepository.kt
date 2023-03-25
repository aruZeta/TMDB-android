package com.aruzeta.tmdb.api.tmdb

import com.aruzeta.tmdb.model.tmdb.api.TmdbApiRoute
import com.aruzeta.tmdb.model.tmdb.data.TrendingList
import retrofit2.Response
import javax.inject.Inject

interface ITmdbRepository {
    suspend fun getTrending(
        mediaType: TmdbApiRoute.MediaType = TmdbApiRoute.MediaType.Movie,
        timeWindow: TmdbApiRoute.TimeWindow = TmdbApiRoute.TimeWindow.Day,
    ): TrendingList
}

class TmdbRepository @Inject constructor(
    private val tmdbApi: TmdbApi,
) : ITmdbRepository {
    private fun <T> Response<T>.getResult(default: () -> T): T =
        this.let { if (it.isSuccessful) it.body() ?: default() else default() }

    override suspend fun getTrending(
        mediaType: TmdbApiRoute.MediaType,
        timeWindow: TmdbApiRoute.TimeWindow,
    ): TrendingList =
        tmdbApi.getTrending(mediaType, timeWindow).getResult { TrendingList(0, emptyList()) }
}
