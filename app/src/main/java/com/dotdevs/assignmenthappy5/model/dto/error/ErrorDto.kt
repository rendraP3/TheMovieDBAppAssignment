package com.dotdevs.assignmenthappy5.model.dto.error

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class ErrorDto(

    @field:Json(name = "status_message")
    val statusMessage: String? = null,

    @field:Json(name = "status_code")
    val statusCode: Int? = null
)
