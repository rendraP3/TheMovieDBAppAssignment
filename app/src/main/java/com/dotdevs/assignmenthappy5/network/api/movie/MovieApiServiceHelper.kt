package com.dotdevs.assignmenthappy5.network.api.movie

import com.dotdevs.assignmenthappy5.model.dto.credit.CreditDto
import com.dotdevs.assignmenthappy5.model.dto.detail.movie.MovieDetailDto
import com.dotdevs.assignmenthappy5.model.dto.detail.movie.MovieDetailExtraDto
import com.dotdevs.assignmenthappy5.model.dto.movie.MovieListDto
import com.dotdevs.assignmenthappy5.model.dto.video.VideoListDto
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiServiceHelper {

    suspend fun getPopularMovies() : MovieListDto

    suspend fun getLatestMovies() : MovieListDto

    suspend fun getNowPlayingMovies() : MovieListDto

    suspend fun getUpcomingMovies() : MovieListDto

    suspend fun getTopRatedMovies() : MovieListDto

    suspend fun getSimilarMovies(
        @Path("movie_id") id: String
    ) : MovieListDto

    suspend fun getMovieDetailWIthExtras(
        @Path("movie_id") id: String,
        @Query("append_to_response") extras: String
    ) : MovieDetailExtraDto

    suspend fun getMovieDetail(
        @Path("movie_id") id: String
    ) : MovieDetailDto

    suspend fun getMovieCredits(
        @Path("movie_id") id: String
    ) : CreditDto

    suspend fun getMovieVideos(
        @Path("movie_id") id: String
    ) : VideoListDto

    suspend fun getMovieRecommendations(
        @Path("movie_id") id: String
    ) : MovieListDto
}