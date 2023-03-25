package com.aruzeta.tmdb.di

import com.aruzeta.tmdb.api.tmdb.TmdbApi
import com.aruzeta.tmdb.repository.tmdb.TmdbRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TmdbRepositoryDI {
    @Singleton
    @Provides
    fun provideTmdbRepository(
        tmdbApi: TmdbApi
    ): TmdbRepository = TmdbRepository(tmdbApi)
}
