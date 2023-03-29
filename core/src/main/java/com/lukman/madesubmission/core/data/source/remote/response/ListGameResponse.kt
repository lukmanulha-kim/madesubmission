package com.lukman.madesubmission.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListGameResponse(
    @field:SerializedName("count")
    val count: String,

    @field:SerializedName("results")
    val results: List<GameResponse>
)
