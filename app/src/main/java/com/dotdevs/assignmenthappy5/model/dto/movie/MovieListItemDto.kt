package com.dotdevs.assignmenthappy5.model.dto.movie

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.io.Serializable

@Keep
@Entity
data class MovieListItemDto (

    @ColumnInfo(name = "adult")
    @field:Json(name = "adult")
    val isAdult : Boolean? = null,

    @ColumnInfo(name = "backdrop_path")
    @field:Json(name = "backdrop_path")
    val backdropPath: String? = null,

    @ColumnInfo(name = "genre_ids")
    @field:Json(name = "genre_ids")
    val genreIds: List<Int>? = null,

    @PrimaryKey
    @field:Json(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "original_language")
    @field:Json(name = "original_language")
    val originalLanguage: String? = null,

    @ColumnInfo(name = "original_title")
    @field:Json(name = "original_title")
    val originalTitle: String? = null,

    @ColumnInfo(name = "overview")
    @field:Json(name = "overview")
    val overview: String? = null,

    @ColumnInfo(name = "popularity")
    @field:Json(name = "popularity")
    val popularity: Double? = null,

    @ColumnInfo(name = "poster_path")
    @field:Json(name = "poster_path")
    val posterPath: String? = null,

    @ColumnInfo(name = "release_date")
    @field:Json(name = "release_date")
    val releaseDate: String? = null,

    @ColumnInfo(name = "title")
    @field:Json(name = "title")
    val title: String? = null,

    @ColumnInfo(name = "video")
    @field:Json(name = "video")
    val itHasVideo: Boolean? = null,

    @ColumnInfo(name = "vote_average")
    @field:Json(name = "vote_average")
    val voteAverage: Double? = null,

    @ColumnInfo(name = "vote_count")
    @field:Json(name = "vote_count")
    val voteCount: Int? = null,

    @ColumnInfo(name = "type")
    var type: String? = null

)