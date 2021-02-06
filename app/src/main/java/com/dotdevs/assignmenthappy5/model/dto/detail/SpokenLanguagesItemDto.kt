package com.dotdevs.assignmenthappy5.model.dto.detail

import androidx.annotation.Keep
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class SpokenLanguagesItemDto (

    @field:Json(name = "english_name")
    val englishName: String? = null,

    @field:Json(name = "iso_639_1")
    val iso639: String? = null,

    @field:Json(name = "name")
    val name: String? = null

)