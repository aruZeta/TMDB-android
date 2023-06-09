package com.aruzeta.tmdb.api.tmdb

import com.aruzeta.tmdb.model.tmdb.api.TmdbApiRoute
import com.aruzeta.tmdb.model.tmdb.data.TrendingList
import com.aruzeta.tmdb.repository.tmdb.ITmdbRepository
import javax.inject.Inject

class TestableTmdbRepository @Inject constructor(
    private val tmdbApi: TmdbApi
) : ITmdbRepository {
    override suspend fun getTrending(
        mediaType: TmdbApiRoute.MediaType,
        timeWindow: TmdbApiRoute.TimeWindow
    ): TrendingList = tmdbApi.getTrending(mediaType, timeWindow).let {
        assert(it.isSuccessful) { "The API request was not successful" }
        val body = it.body()
        assert(body != null) { "The API response is null" }
        body!!
    }
}
