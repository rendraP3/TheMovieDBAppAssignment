package com.dotdevs.assignmenthappy5.model.dto.detail.tv

import com.dotdevs.assignmenthappy5.model.dto.credit.CreditDto
import com.dotdevs.assignmenthappy5.model.dto.tv.TvListDto
import com.dotdevs.assignmenthappy5.model.dto.video.VideoListDto
import com.squareup.moshi.Json

data class TvDetailExtraDto(

    @field:Json(name = "videos")
    val videos: VideoListDto? = null,

    @field:Json(name = "credits")
    val credits: CreditDto? = null,

    @field:Json(name = "recommendations")
    val recommendations: TvListDto? = null

) : TvDetailDto()
