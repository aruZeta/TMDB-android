package com.aruzeta.tmdb.di

import com.aruzeta.tmdb.repository.tmdb.ITmdbRepository
import com.aruzeta.tmdb.repository.tmdb.TmdbRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TmdbRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindTmdbRepository(
        tmdbRepository: TmdbRepository
    ): ITmdbRepository
}
