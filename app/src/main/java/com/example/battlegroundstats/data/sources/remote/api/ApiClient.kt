package com.example.battlegroundstats.data.sources.remote.api

import com.example.battlegroundstats.data.sources.remote.auth.PUBGAuthInterceptor
import com.example.battlegroundstats.data.sources.remote.service.PUBGApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private const val BASE_URL = "https://api.pubg.com/"
    private const val TIMEOUT = 20L
    private const val API_KEY =
        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI5ZDc3ZWNhMC1lYjcwLTAxM2ItZGJiOS00MmY3ZTdiY2Q3MWIiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNjg2NTg5MjUzLCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InB1Ymctcm95YWwtc3RhIn0.uDax2C3EXxi8N9tQCkJFjPUzcrKbKB1LD-uaWASvRWg"

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(PUBGAuthInterceptor(API_KEY))
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun pubgService(): PUBGApiService = retrofit.create(PUBGApiService::class.java)

}