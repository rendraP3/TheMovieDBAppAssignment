package com.dotdevs.assignmenthappy5.model.dto.detail.tv

import com.squareup.moshi.Json

data class NetworkItemDto(

    @field:Json(name = "logo_path")
    val logoPath: String? = null,

    @field:Json(name = "name")
    val name: String? = null,

    @field:Json(name = "id")
    val id: Int? = null,

    @field:Json(name = "origin_country")
    val originCountry: String? = null

)
