package com.dotdevs.assignmenthappy5.model.dto.detail

import androidx.annotation.Keep
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class ProductionCountryItemDto(

    @field:Json(name = "iso_3166_1")
    val iso3166: String? = null,

    @field:Json(name = "name")
    val name: String? = null,
)