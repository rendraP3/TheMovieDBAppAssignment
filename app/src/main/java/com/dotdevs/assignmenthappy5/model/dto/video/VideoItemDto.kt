package com.dotdevs.assignmenthappy5.model.dto.video

import android.os.Parcelable
import androidx.annotation.Keep
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Keep
data class VideoItemDto(

    @field:Json(name = "id")
    val id: String? = null,

    @field:Json(name = "iso_639_1")
    val iso639: String? = null,

    @field:Json(name = "iso_3166_1")
    val iso3166: String? = null,

    @field:Json(name = "key")
    val key: String? = null,

    @field:Json(name = "name")
    val name: String? = null,

    @field:Json(name = "site")
    val site: String? = null,

    @field:Json(name = "size")
    val size: Int? = null,

    @field:Json(name = "type")
    val type: String? = null

)