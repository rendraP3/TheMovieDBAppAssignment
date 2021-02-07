package com.dotdevs.assignmenthappy5.model.dto.detail

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class GenreItemDto (

    @field:Json(name = "id")
    val id: Int? = null,

    @field:Json(name = "name")
    val name: String? = null,

)