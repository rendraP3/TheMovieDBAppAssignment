package com.dotdevs.assignmenthappy5.network.api.movie.repository

import com.dotdevs.assignmenthappy5.model.dto.movie.MovieListDto
import com.dotdevs.assignmenthappy5.network.api.movie.MovieApiServiceHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieListRepository @Inject constructor(
    private val apiServiceHelper: MovieApiServiceHelper
) {

    suspend fun getPopularMovieList() : MovieListDto {
        return apiServiceHelper.getPopularMovies()
    }

    suspend fun getUpcomingMovieList() : MovieListDto {
        return apiServiceHelper.getUpcomingMovies()
    }

    suspend fun getPlayingMovieList() : MovieListDto {
        return apiServiceHelper.getNowPlayingMovies()
    }

    suspend fun getTopRatedMovieList() : MovieListDto {
        return apiServiceHelper.getTopRatedMovies()
    }

    suspend fun getSimilarMovieList(
        movieId: String
    ) : MovieListDto {
        return apiServiceHelper.getSimilarMovies(
            movieId
        )
    }

}