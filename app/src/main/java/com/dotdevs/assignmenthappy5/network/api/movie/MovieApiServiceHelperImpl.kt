package com.dotdevs.assignmenthappy5.network.api.movie

import com.dotdevs.assignmenthappy5.model.dto.credit.CreditDto
import com.dotdevs.assignmenthappy5.model.dto.detail.movie.MovieDetailDto
import com.dotdevs.assignmenthappy5.model.dto.detail.movie.MovieDetailExtraDto
import com.dotdevs.assignmenthappy5.model.dto.movie.MovieListDto
import com.dotdevs.assignmenthappy5.model.dto.video.VideoListDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieApiServiceHelperImpl @Inject constructor(
    private val movieApiService: MovieApiService
) : MovieApiServiceHelper {
    override suspend fun getPopularMovies() = movieApiService.getPopularMovies()

    override suspend fun getLatestMovies() = movieApiService.getLatestMovies()

    override suspend fun getNowPlayingMovies() = movieApiService.getNowPlayingMovies()

    override suspend fun getUpcomingMovies() = movieApiService.getUpcomingMovies()

    override suspend fun getTopRatedMovies() = movieApiService.getTopRatedMovies()

    override suspend fun getSimilarMovies(
        id: String
    ) = movieApiService.getSimilarMovies(id)

    override suspend fun getMovieDetailWIthExtras(
        id: String,
        extras: String
    ) = movieApiService.getMovieDetailWIthExtras(id, extras)

    override suspend fun getMovieDetail(
        id: String
    ) = movieApiService.getMovieDetail(id)

    override suspend fun getMovieCredits(
        id: String
    ) = movieApiService.getMovieCredits(id)

    override suspend fun getMovieVideos(
        id: String
    ) = movieApiService.getMovieVideos(id)

    override suspend fun getMovieRecommendations(
        id: String
    ) = movieApiService.getMovieRecommendations(id)
}