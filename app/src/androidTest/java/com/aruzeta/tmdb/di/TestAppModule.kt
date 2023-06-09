package com.aruzeta.tmdb.di

import com.aruzeta.tmdb.api.tmdb.AuthInjector
import com.aruzeta.tmdb.api.tmdb.TMDB_API_URL
import com.aruzeta.tmdb.api.tmdb.TmdbApi
import com.aruzeta.tmdb.model.tmdb.api.TmdbApiRouteConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {
    @Singleton
    @Provides
    fun provideTmdbApi(): TmdbApi = Retrofit.Builder()
        .baseUrl(TMDB_API_URL)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(AuthInjector())
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
                .build()
        )
        .addConverterFactory(TmdbApiRouteConverterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TmdbApi::class.java)
}
