package com.dotdevs.assignmenthappy5.model.dto.detail

import androidx.annotation.Keep
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class GenreItemDto (

    @field:Json(name = "id")
    val id: Int? = null,

    @field:Json(name = "name")
    val name: String? = null

)