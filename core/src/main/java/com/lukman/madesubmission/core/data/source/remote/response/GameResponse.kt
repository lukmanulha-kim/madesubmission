package com.lukman.madesubmission.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GameResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("slug")
    val slug: String,

    @field:SerializedName("released")
    val released: String,

    @field:SerializedName("background_image")
    val background_image: String,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("rating_top")
    val rating_top: Int
)
