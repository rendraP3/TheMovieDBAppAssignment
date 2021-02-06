package com.dotdevs.assignmenthappy5.network.api.movie

import com.dotdevs.assignmenthappy5.model.dto.credit.CreditDto
import com.dotdevs.assignmenthappy5.model.dto.detail.movie.MovieDetailDto
import com.dotdevs.assignmenthappy5.model.dto.detail.movie.MovieDetailExtraDto
import com.dotdevs.assignmenthappy5.model.dto.movie.MovieListDto
import com.dotdevs.assignmenthappy5.model.dto.video.VideoListDto
import com.dotdevs.assignmenthappy5.network.RetrofitInstance
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiInterface {

    companion object {
        fun getClient() : MovieApiInterface {
            val retrofit = RetrofitInstance.getInstance()

            return retrofit.create(MovieApiInterface::class.java)
        }
    }

    @GET("movie/popular")
    suspend fun getPopularMovies() : Response<MovieListDto>

    @GET("movie/latest")
    suspend fun getLatestMovies() : Response<MovieListDto>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies() : Response<MovieListDto>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies() : Response<MovieListDto>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies() : Response<MovieListDto>

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path("movie_id") id: String
    ) : Response<MovieListDto>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetailWIthExtras(
        @Path("movie_id") id: String,
        @Query("append_to_response") extras: String
    ) : Response<MovieDetailExtraDto>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") id: String
    ) : Response<MovieDetailDto>

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(
        @Path("movie_id") id: String
    ) : Response<CreditDto>

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieVideos(
        @Path("movie_id") id: String
    ) : Response<VideoListDto>

    @GET("movie/{movie_id}/recommendations")
    suspend fun getMovieRecommendations(
        @Path("movie_id") id: String
    ) : Response<MovieListDto>

}