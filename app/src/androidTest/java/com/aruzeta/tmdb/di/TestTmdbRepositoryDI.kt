package com.aruzeta.tmdb.di

import com.aruzeta.tmdb.api.tmdb.TestableTmdbRepository
import com.aruzeta.tmdb.api.tmdb.TmdbApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestTmdbRepositoryDI {
    @Singleton
    @Provides
    fun provideTestableTmdbRepository(
        tmdbApi: TmdbApi
    ): TestableTmdbRepository = TestableTmdbRepository(tmdbApi)
}
