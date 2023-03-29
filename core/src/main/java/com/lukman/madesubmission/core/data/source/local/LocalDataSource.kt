package com.lukman.madesubmission.core.data.source.local

import com.lukman.madesubmission.core.data.source.local.entity.GamesEntity
import com.lukman.madesubmission.core.data.source.local.room.GameDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val gameDao: com.lukman.madesubmission.core.data.source.local.room.GameDao) {

    fun getAllGame(): Flow<List<com.lukman.madesubmission.core.data.source.local.entity.GamesEntity>> = gameDao.getAllGame()

    fun getFavoriteGame(): Flow<List<com.lukman.madesubmission.core.data.source.local.entity.GamesEntity>> = gameDao.getFavoriteGame()

    suspend fun insertGame(gameList: List<com.lukman.madesubmission.core.data.source.local.entity.GamesEntity>) = gameDao.insertGame(gameList)

    fun setFavoriteGame(game: com.lukman.madesubmission.core.data.source.local.entity.GamesEntity, newState: Boolean) {
        game.isFavorite = newState
        gameDao.updateFavoriteGame(game)
    }
}