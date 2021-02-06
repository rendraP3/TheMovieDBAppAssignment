package com.dotdevs.assignmenthappy5.model.dto.detail.movie

import androidx.annotation.Keep
import com.dotdevs.assignmenthappy5.model.dto.credit.CreditDto
import com.dotdevs.assignmenthappy5.model.dto.movie.MovieListDto
import com.dotdevs.assignmenthappy5.model.dto.video.VideoListDto
import com.squareup.moshi.Json

@Keep
data class MovieDetailExtraDto (

    @field:Json(name = "videos")
    val videos: VideoListDto? = null,

    @field:Json(name = "credits")
    val credits: CreditDto? = null,

    @field:Json(name = "recommendations")
    val recommendations: MovieListDto? = null

) : MovieDetailDto()