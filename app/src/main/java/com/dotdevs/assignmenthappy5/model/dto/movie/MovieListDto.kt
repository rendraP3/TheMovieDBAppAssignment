package com.dotdevs.assignmenthappy5.model.dto.movie

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class MovieListDto (

    @field:Json(name = "page")
    val page : Int? = null,

    @field:Json(name = "results")
    val results: List<MovieDto>? = null,

    @field:Json(name = "total_pages")
    val totalPages : Int? = null,

    @field:Json(name = "total_results")
    val totalResults : Int? = null

)