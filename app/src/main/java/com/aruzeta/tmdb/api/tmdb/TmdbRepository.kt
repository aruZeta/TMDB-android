package com.aruzeta.tmdb.api.tmdb

import com.aruzeta.tmdb.model.tmdb.api.MediaType
import com.aruzeta.tmdb.model.tmdb.api.TimeWindow
import com.aruzeta.tmdb.model.tmdb.data.TrendingList
import retrofit2.Response
import javax.inject.Inject

interface ITmdbRepository {
    suspend fun getTrending(
        mediaType: MediaType = MediaType.Movie,
        timeWindow: TimeWindow = TimeWindow.Day,
    ): TrendingList
}

class TmdbRepository @Inject constructor(
    private val tmdbApi: TmdbApi,
) : ITmdbRepository {
    private fun <T> Response<T>.getResult(default: () -> T): T =
        this.let { if (it.isSuccessful) it.body() ?: default() else default() }

    override suspend fun getTrending(
        mediaType: MediaType,
        timeWindow: TimeWindow,
    ): TrendingList =
        tmdbApi.getTrending(mediaType, timeWindow).getResult { TrendingList(0, emptyList()) }
}
