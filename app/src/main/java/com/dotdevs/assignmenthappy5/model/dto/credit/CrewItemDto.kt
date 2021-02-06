package com.dotdevs.assignmenthappy5.model.dto.credit

import androidx.annotation.Keep
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class CrewItemDto(

    @field:Json(name = "adult")
    val isAdult: Boolean? = null,

    @field:Json(name = "gender")
    val gender: Int? = null,

    @field:Json(name = "id")
    val id: Int? = null,

    @field:Json(name = "known_for_department")
    val knownForDepartment: String? = null,

    @field:Json(name = "name")
    val name: String? = null,

    @field:Json(name = "original_name")
    val originalName: String? = null,

    @field:Json(name = "popularity")
    val popularity: Double? = null,

    @field:Json(name = "profile_path")
    val profilePath: String? = null,

    @field:Json(name = "credit_id")
    val creditId: String? = null,

    @field:Json(name = "department")
    val department: String? = null,

    @field:Json(name = "job")
    val job: String? = null

)