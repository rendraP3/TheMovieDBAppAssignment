package com.dotdevs.assignmenthappy5.network

import com.dotdevs.assignmenthappy5.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private lateinit var retrofit: Retrofit

    fun getInstance() : Retrofit {
        if (!this::retrofit.isInitialized) {
            retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(movieDbOkHttpClient())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }

        return retrofit
    }

    private fun movieDbOkHttpClient() : OkHttpClient {
        return OkHttpClient.Builder().apply {
            HttpLoggingInterceptor().also { interceptor ->
                interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE

                addInterceptor(interceptor)
            }
            addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer ${BuildConfig.API_KEY}").build()
                chain.proceed(request)
            }
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            followRedirects(true)
            followSslRedirects(true)
        }.build()
    }
}