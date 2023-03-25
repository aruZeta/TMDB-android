package com.aruzeta.tmdb.di

import com.aruzeta.tmdb.api.tmdb.*
import com.aruzeta.tmdb.model.tmdb.api.TmdbApiRouteConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TmdbApiDI {
    @Singleton
    @Provides
    fun provideTmdbApi(): TmdbApi = Retrofit.Builder()
        .baseUrl(TMDB_API_URL)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(AuthInjector())
                .build()
        )
        .addConverterFactory(TmdbApiRouteConverterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TmdbApi::class.java)

    @Singleton
    @Provides
    fun provideTmdbRepository(
        tmdbApi: TmdbApi
    ): ITmdbRepository = TmdbRepository(tmdbApi)
}
