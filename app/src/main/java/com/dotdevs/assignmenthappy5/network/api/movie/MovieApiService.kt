package com.dotdevs.assignmenthappy5.network.api.movie

import com.dotdevs.assignmenthappy5.model.dto.credit.CreditDto
import com.dotdevs.assignmenthappy5.model.dto.detail.movie.MovieDetailDto
import com.dotdevs.assignmenthappy5.model.dto.detail.movie.MovieDetailExtraDto
import com.dotdevs.assignmenthappy5.model.dto.movie.MovieListDto
import com.dotdevs.assignmenthappy5.model.dto.video.VideoListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies() : MovieListDto

    @GET("movie/latest")
    suspend fun getLatestMovies() : MovieListDto

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies() : MovieListDto

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies() : MovieListDto

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies() : MovieListDto

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path("movie_id") id: String
    ) : MovieListDto

    @GET("movie/{movie_id}")
    suspend fun getMovieDetailWIthExtras(
        @Path("movie_id") id: String,
        @Query("append_to_response") extras: String
    ) : MovieDetailExtraDto

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") id: String
    ) : MovieDetailDto

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(
        @Path("movie_id") id: String
    ) : CreditDto

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieVideos(
        @Path("movie_id") id: String
    ) : VideoListDto

    @GET("movie/{movie_id}/recommendations")
    suspend fun getMovieRecommendations(
        @Path("movie_id") id: String
    ) : MovieListDto

}