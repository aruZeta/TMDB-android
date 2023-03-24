package com.aruzeta.tmdb.tests

import android.util.Log
import com.aruzeta.tmdb.api.tmdb.TestableTmdbRepository
import com.aruzeta.tmdb.di.TmdbApiDI
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
@UninstallModules(TmdbApiDI::class)
class TmdbApiTest {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var tmdbRepository: TestableTmdbRepository

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun getTrendingMovies() = runBlocking {
        val result = tmdbRepository.getTrending()
        Log.d("Trending movies", result.results.joinToString("\n") { it.title })
        assert(result.page != 0) { "Received 0 pages of trending movies" }
        assert(result.results.isNotEmpty()) { "Received empty list of trending movies" }
    }
}
