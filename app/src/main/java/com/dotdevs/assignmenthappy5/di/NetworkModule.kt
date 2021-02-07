package com.dotdevs.assignmenthappy5.di

import com.dotdevs.assignmenthappy5.BuildConfig
import com.dotdevs.assignmenthappy5.constants.RestConfig
import com.dotdevs.assignmenthappy5.network.api.movie.MovieApiService
import com.dotdevs.assignmenthappy5.network.api.movie.MovieApiServiceHelper
import com.dotdevs.assignmenthappy5.network.api.movie.MovieApiServiceHelperImpl
import com.dotdevs.assignmenthappy5.network.api.movie.MovieRemoteDataSource
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl() = RestConfig.SERVER_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        OkHttpClient.Builder().apply {
            addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer ${BuildConfig.API_KEY}").build()
                chain.proceed(request)
            }
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
        }.build()
    } else {
        OkHttpClient.Builder().apply {
            readTimeout(30, TimeUnit.SECONDS)
            connectTimeout(30, TimeUnit.SECONDS)
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        BaseUrl: String
    ) : Retrofit = Retrofit.Builder().apply {
        baseUrl(BaseUrl)
        client(okHttpClient)
        addConverterFactory(MoshiConverterFactory.create().asLenient())
    }.build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(MovieApiService::class.java)

    @Provides
    @Singleton
    fun provideApiServiceHelper(apiHelper: MovieApiServiceHelperImpl): MovieApiServiceHelper = apiHelper

    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(
        movieApiService: MovieApiService
    ) = MovieRemoteDataSource(movieApiService)

}