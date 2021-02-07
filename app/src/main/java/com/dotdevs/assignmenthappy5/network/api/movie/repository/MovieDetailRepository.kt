package com.dotdevs.assignmenthappy5.network.api.movie.repository

import com.dotdevs.assignmenthappy5.model.dto.credit.CreditDto
import com.dotdevs.assignmenthappy5.model.dto.detail.movie.MovieDetailDto
import com.dotdevs.assignmenthappy5.model.dto.detail.movie.MovieDetailExtraDto
import com.dotdevs.assignmenthappy5.model.dto.movie.MovieListDto
import com.dotdevs.assignmenthappy5.model.dto.video.VideoListDto
import com.dotdevs.assignmenthappy5.network.api.movie.MovieApiServiceHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailRepository @Inject constructor(
    private val apiServiceHelper: MovieApiServiceHelper
    ) {

    suspend fun getMovieDetailWithExtras(
        movieId: String,
        withVideos: Boolean,
        withCredits: Boolean,
        withRecommendations: Boolean
    ) : MovieDetailExtraDto {
        var extras = ""

        if (withVideos) extras += "videos,"
        if (withCredits) extras += "credits,"
        if (withRecommendations) extras += "recommendations"

        return apiServiceHelper.getMovieDetailWIthExtras(
            movieId,
            extras
        )
    }

    suspend fun getMovieDetails(
        movieId: String
    ) : MovieDetailDto? {
        return apiServiceHelper.getMovieDetail(movieId)
    }

    suspend fun getCastCrew(
        movieId: String
    ) : CreditDto? {
        return apiServiceHelper.getMovieCredits(movieId)
    }

    suspend fun getVideos(
        movieId: String
    ) : VideoListDto? {
        return apiServiceHelper.getMovieVideos(movieId)
    }

    suspend fun getRecommendations(
        movieId: String
    ) : MovieListDto? {
        return apiServiceHelper.getMovieRecommendations(movieId)
    }

}