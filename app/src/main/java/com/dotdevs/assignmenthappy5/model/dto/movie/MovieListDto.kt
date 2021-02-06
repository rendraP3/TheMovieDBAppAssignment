package com.dotdevs.assignmenthappy5.model.dto.movie

import androidx.annotation.Keep
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class MovieListDto (

    @field:Json(name = "page")
    val page : Int? = null,

    @field:Json(name = "results")
    val results: List<MovieListItemDto>? = null,

    @field:Json(name = "total_pages")
    val totalPages : Int? = null,

    @field:Json(name = "total_results")
    val totalResults : Int? = null

)