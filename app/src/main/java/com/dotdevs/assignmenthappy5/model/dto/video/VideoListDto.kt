package com.dotdevs.assignmenthappy5.model.dto.video

import androidx.annotation.Keep
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class VideoListDto(

    @field:Json(name = "id")
    val id: Int? = null,

    @field:Json(name = "results")
    val results: List<VideoItemDto>? = null

)