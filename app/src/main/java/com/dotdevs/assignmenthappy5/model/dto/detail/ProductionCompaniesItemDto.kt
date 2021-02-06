package com.dotdevs.assignmenthappy5.model.dto.detail

import androidx.annotation.Keep
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class ProductionCompaniesItemDto (

    @field:Json(name = "id")
    val id: Int? = null,

    @field:Json(name = "logo_path")
    val logoPath: String? = null,

    @field:Json(name = "name")
    val name: String? = null,

    @field:Json(name = "origin_country")
    val originCountry: String? = null

)