package com.lukman.madesubmission.core.domain.usecase

import com.lukman.madesubmission.core.data.source.Resource
import com.lukman.madesubmission.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameUseCase {

    fun getAllGame(): Flow<Resource<List<Game>>>
    fun getFavoriteGame(): Flow<List<Game>>
    fun setFavoriteGame(game: Game, state: Boolean)

}