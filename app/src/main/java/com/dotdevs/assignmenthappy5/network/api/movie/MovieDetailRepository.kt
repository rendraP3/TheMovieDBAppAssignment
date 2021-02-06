package com.dotdevs.assignmenthappy5.network.api.movie

import com.dotdevs.assignmenthappy5.model.dto.credit.CreditDto
import com.dotdevs.assignmenthappy5.model.dto.detail.movie.MovieDetailDto
import com.dotdevs.assignmenthappy5.model.dto.detail.movie.MovieDetailExtraDto
import com.dotdevs.assignmenthappy5.model.dto.movie.MovieListDto
import com.dotdevs.assignmenthappy5.model.dto.video.VideoListDto
import com.dotdevs.assignmenthappy5.network.BaseRepository

class MovieDetailRepository(private val client: MovieApiInterface) : BaseRepository() {

    suspend fun getMovieDetailWithExtras(
        movieId: String,
        withVideos: Boolean,
        withCredits: Boolean,
        withRecommendations: Boolean
    ) : MovieDetailExtraDto? {
        var extras = ""

        if (withVideos) extras += "videos,"
        if (withCredits) extras += "credits,"
        if (withRecommendations) extras += "recommendations"

        return apiCall(
            call = {
                client.getMovieDetailWIthExtras(
                movieId,
                extras
                )
            },
            errorMessage = "Error while fetching movie details"
        )
    }

    suspend fun getMovieDetails(
        movieId: String
    ) : MovieDetailDto? {

        return apiCall(
            call = {
                client.getMovieDetail(movieId)
            },
            errorMessage = "Error while fetching movie details"
        )

    }

    suspend fun getCastCrew(
        movieId: String
    ) : CreditDto? {

        return apiCall(
            call = {
                client.getMovieCredits(movieId)
            },
            errorMessage = "Error while fetching movie credits"
        )

    }

    suspend fun getVideos(
        movieId: String
    ) : VideoListDto? {

        return apiCall(
            call = {
                client.getMovieVideos(movieId)
            },
            errorMessage = "Error while fetching movie videos"
        )

    }

    suspend fun getRecommendations(
        movieId: String
    ) : MovieListDto? {

        return apiCall(
            call = {
                client.getMovieRecommendations(movieId)
            },
            errorMessage = "Error while fetching movie recommendations"
        )

    }

}