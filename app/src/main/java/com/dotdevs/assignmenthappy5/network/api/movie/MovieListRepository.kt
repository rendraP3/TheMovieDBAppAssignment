package com.dotdevs.assignmenthappy5.network.api.movie

import com.dotdevs.assignmenthappy5.model.dto.movie.MovieListDto
import com.dotdevs.assignmenthappy5.network.BaseRepository

class MovieListRepository(private val client: MovieApiInterface) : BaseRepository() {

    suspend fun getPopularMovieList() : MovieListDto? {

        return apiCall(
            call = {
                client.getPopularMovies()
            },
            errorMessage = "Error while fetching popular movies"
        ).apply {
            this?.results?.forEach {
                it.type = "popular"
            }
        }

    }

    suspend fun getUpcomingMovieList() : MovieListDto? {

        return apiCall(
            call = {
                client.getUpcomingMovies()
            },
            errorMessage = "Error while fetching upcoming movies"
        ).apply {
            this?.results?.forEach {
                it.type = "upcoming"
            }
        }

    }

    suspend fun getPlayingMovieList() : MovieListDto? {

        return apiCall(
            call = {
                client.getNowPlayingMovies()
            },
            errorMessage = "Error while fetching playing movies"
        ).apply {
            this?.results?.forEach {
                it.type = "playing"
            }
        }

    }

    suspend fun getTopRatedMovieList() : MovieListDto? {

        return apiCall(
            call = {
                client.getTopRatedMovies()
            },
            errorMessage = "Error while fetching top rated movies"
        ).apply {
            this?.results?.forEach {
                it.type = "top_rated"
            }
        }

    }

    suspend fun getSimilarMovieList(
        movieId: String
    ) : MovieListDto? {

        return apiCall(
            call = {
                client.getSimilarMovies(movieId)
            },
            errorMessage = "Error while fetching similar movies"
        ).apply {
            this?.results?.forEach {
                it.type = "similar"
            }
        }

    }

}