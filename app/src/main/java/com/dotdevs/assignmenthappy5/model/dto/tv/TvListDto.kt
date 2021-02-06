package com.dotdevs.assignmenthappy5.model.dto.tv

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvListDto(

    @field:Json(name = "page")
    val page: Int? = null,

    @field:Json(name = "results")
    val results: List<TvListItemDto>? = null,

    @field:Json(name = "total_pages")
    val totalPages: Int? = null,

    @field:Json(name = "total_results")
    val totalResults: Int? = null

): Parcelable
