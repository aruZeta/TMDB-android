package com.aruzeta.tmdb.model.tmdb.data

import com.google.gson.annotations.SerializedName

data class TrendingList(
    @SerializedName("page") @JvmField val page: Int,
    @SerializedName("results") @JvmField val results: List<Movie>,
)

data class Movie(
    @SerializedName("id") @JvmField val id: Int,
    @SerializedName("title") @JvmField val title: String,
)
