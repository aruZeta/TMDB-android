package com.aruzeta.tmdb.model.tmdb.data

import androidx.datastore.preferences.protobuf.Internal.IntList
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

sealed interface Movie {
    data class MinimumData(
        @SerializedName("id") @JvmField val id: Int,
        @SerializedName("title") @JvmField val title: String,
        @SerializedName("poster_path") @JvmField val imagePath: String,
    ) : Movie

    data class FullData(
        @SerializedName("id") @JvmField val id: Int,
        @SerializedName("title") @JvmField val title: String,
        @SerializedName("adult") @JvmField val is18Plus: Boolean,
        @SerializedName("poster_path") @JvmField val imagePath: String,
        @SerializedName("original_language") @JvmField val originalLanguage: String,
        @SerializedName("overview") @JvmField val overview: String,
        @SerializedName("genre_ids") @JvmField val genres: IntList,
        @SerializedName("release_date") @JvmField val releaseDate: LocalDate,
        @SerializedName("popularity") @JvmField val popularity: Double,
        @SerializedName("vote_average") @JvmField val voteAvg: Float,
        @SerializedName("vote_count") @JvmField val voteCount: Int,
    ) : Movie
}
