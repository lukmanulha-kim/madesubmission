package com.lukman.madesubmission.core.di

import android.content.Context
import androidx.room.Room
import com.lukman.madesubmission.core.data.source.local.room.GameDao
import com.lukman.madesubmission.core.data.source.local.room.GameDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): com.lukman.madesubmission.core.data.source.local.room.GameDatabase = Room.databaseBuilder(
        context,
        com.lukman.madesubmission.core.data.source.local.room.GameDatabase::class.java, "Game.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: com.lukman.madesubmission.core.data.source.local.room.GameDatabase): com.lukman.madesubmission.core.data.source.local.room.GameDao = database.gameDao()

}