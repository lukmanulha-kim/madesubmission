package com.lukman.madesubmission.core.domain.repository

import com.lukman.madesubmission.core.data.source.Resource
import com.lukman.madesubmission.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface IGameRepository {
    fun getAllGame(): Flow<Resource<List<Game>>>

    fun getFavoriteGame(): Flow<List<Game>>

    fun setFavoriteGame(tourism: Game, state: Boolean)
}