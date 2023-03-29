package com.lukman.madesubmission.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "games")
data class GamesEntity(
    @PrimaryKey
    @ColumnInfo(name = "gameId")
    var gameId: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "slug")
    var slug: String,

    @ColumnInfo(name = "released")
    var released: String,

    @ColumnInfo(name = "background_image")
    var background_image: String,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "rating_top")
    var rating_top: Int,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
):Parcelable
