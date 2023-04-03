package com.aruzeta.tmdb.repository.tmdb

import com.aruzeta.tmdb.model.tmdb.api.TmdbApiRoute
import com.aruzeta.tmdb.model.tmdb.data.TrendingList

interface ITmdbRepository {
    suspend fun getTrending(
        mediaType: TmdbApiRoute.MediaType = TmdbApiRoute.MediaType.Movie,
        timeWindow: TmdbApiRoute.TimeWindow = TmdbApiRoute.TimeWindow.Day,
    ): TrendingList
}
