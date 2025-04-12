package com.mahmoudbashir.tmdb_movie_app.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val requestBuilder = request.newBuilder()

        //todo requestBuilder.header("Authorization", "Bearer ${BuildConfig.TMDB_API_TOKEN}")
        requestBuilder.header("Accept", "application/json")
        requestBuilder.method(request.method, request.body)

        return chain.proceed(requestBuilder.build())
    }
}