package com.lukman.madesubmission.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val gameId: String,
    val name: String,
    val slug: String,
    val released: String,
    val background_image: String,
    val rating: Double,
    val rating_top: Int,
    val isFavorite: Boolean
): Parcelable
