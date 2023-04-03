@file:Suppress("NOTHING_TO_INLINE")

package com.aruzeta.tmdb.api

import okhttp3.Request
import retrofit2.Invocation

inline fun Request.hasAnnotation(annotation: Class<out Annotation>): Boolean =
    this.tag(Invocation::class.java)?.method()?.isAnnotationPresent(annotation) ?: false
