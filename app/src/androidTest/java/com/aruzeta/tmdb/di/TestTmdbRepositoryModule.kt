package com.aruzeta.tmdb.di

import com.aruzeta.tmdb.api.tmdb.TestableTmdbRepository
import com.aruzeta.tmdb.repository.tmdb.ITmdbRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
@Suppress("unused")
abstract class TestTmdbRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindTesteableTmdbRepository(
        tmdbRepository: TestableTmdbRepository
    ): ITmdbRepository
}
