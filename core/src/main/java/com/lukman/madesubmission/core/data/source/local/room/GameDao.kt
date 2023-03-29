package com.lukman.madesubmission.core.data.source.local.room

import androidx.room.*
import com.lukman.madesubmission.core.data.source.local.entity.GamesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {
    @Query("SELECT * FROM games")
    fun getAllGame(): Flow<List<com.lukman.madesubmission.core.data.source.local.entity.GamesEntity>>

    @Query("SELECT * FROM games where isFavorite = 1")
    fun getFavoriteGame(): Flow<List<com.lukman.madesubmission.core.data.source.local.entity.GamesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: List<com.lukman.madesubmission.core.data.source.local.entity.GamesEntity>)

    @Update
    fun updateFavoriteGame(game: com.lukman.madesubmission.core.data.source.local.entity.GamesEntity)
}