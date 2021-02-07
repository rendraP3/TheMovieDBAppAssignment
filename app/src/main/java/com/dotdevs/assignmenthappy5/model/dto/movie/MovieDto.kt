package com.dotdevs.assignmenthappy5.model.dto.movie

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
data class MovieDto (

    @field:Json(name = "adult")
    val isAdult : Boolean? = null,

    @field:Json(name = "backdrop_path")
    val backdropPath: String? = null,

    @field:Json(name = "genre_ids")
    val genreIds: List<Int>? = null,

    @field:Json(name = "id")
    val id: Int? = null,

    @field:Json(name = "original_language")
    val originalLanguage: String? = null,

    @field:Json(name = "original_title")
    val originalTitle: String? = null,

    @field:Json(name = "overview")
    val overview: String? = null,

    @field:Json(name = "popularity")
    val popularity: Double? = null,

    @field:Json(name = "poster_path")
    val posterPath: String? = null,

    @field:Json(name = "release_date")
    val releaseDate: String? = null,

    @field:Json(name = "title")
    val title: String? = null,

    @field:Json(name = "video")
    val itHasVideo: Boolean? = null,

    @field:Json(name = "vote_average")
    val voteAverage: Double? = null,

    @field:Json(name = "vote_count")
    val voteCount: Int? = null,

    var type: String? = null

)