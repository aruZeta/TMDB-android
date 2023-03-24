package com.aruzeta.tmdb.api.tmdb

import com.aruzeta.tmdb.model.tmdb.api.MediaType
import com.aruzeta.tmdb.model.tmdb.api.TimeWindow
import com.aruzeta.tmdb.model.tmdb.data.TrendingList

class TestableTmdbRepository(
    private val tmdbApi: TmdbApi
) : ITmdbRepository {
    override suspend fun getTrending(
        mediaType: MediaType,
        timeWindow: TimeWindow
    ): TrendingList = tmdbApi.getTrending(mediaType, timeWindow).let {
        assert(it.isSuccessful) { "The API request was not successful" }
        val body = it.body()
        assert(body != null) { "The API response is null" }
        body!!
    }
}
