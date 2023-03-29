package com.lukman.madesubmission.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lukman.madesubmission.core.data.source.local.entity.GamesEntity

@Database(entities = [com.lukman.madesubmission.core.data.source.local.entity.GamesEntity::class], version = 1, exportSchema = false)
abstract class GameDatabase: RoomDatabase() {

    abstract fun gameDao() : com.lukman.madesubmission.core.data.source.local.room.GameDao
}