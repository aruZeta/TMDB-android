package com.aruzeta.tmdb.model.tmdb.data

import com.google.gson.annotations.SerializedName

data class TrendingList(
    @SerializedName("page") @JvmField val page: Int,
    @SerializedName("results") @JvmField val results: List<Movie.MinimumData>,
)
