package com.example.battlegroundstats.data.sources.remote.auth

import okhttp3.Interceptor
import okhttp3.Response

class PUBGAuthInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestWithAuth = chain.request().newBuilder()
            .header("Authorization", "Bearer $apiKey")
            .header("Accept", ACCEPT_FORMAT)
            .build()
        return chain.proceed(requestWithAuth)
    }

    companion object {
        private const val ACCEPT_FORMAT = "application/vnd.api+json"
    }
}