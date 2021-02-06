package com.dotdevs.assignmenthappy5.model.dto.credit

import androidx.annotation.Keep
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class CreditDto(

    @field:Json(name = "id")
    val id: Int? = null,

    @field:Json(name = "cast")
    val casts: List<CastItemDto>? = null,

    @field:Json(name = "crew")
    val crews: List<CrewItemDto>? = null

)