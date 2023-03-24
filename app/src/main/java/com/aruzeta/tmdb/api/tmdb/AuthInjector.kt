package com.aruzeta.tmdb.api.tmdb

import com.aruzeta.tmdb.BuildConfig
import com.aruzeta.tmdb.api.hasAnnotation
import okhttp3.Interceptor
import okhttp3.Response

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class InjectAuth

class AuthInjector : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.proceed(
        chain.request().let { request ->
            if (request.hasAnnotation(InjectAuth::class.java)) request.newBuilder()
                .addHeader("Authorization", "Bearer ${BuildConfig.TMDB_API_KEY}")
                .build()
            else request
        }
    )
}
