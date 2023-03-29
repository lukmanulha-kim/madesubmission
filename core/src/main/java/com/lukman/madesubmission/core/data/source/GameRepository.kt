package com.lukman.madesubmission.core.data.source

import com.lukman.madesubmission.core.data.source.local.LocalDataSource
import com.lukman.madesubmission.core.data.source.remote.RemoteDataSource
import com.lukman.madesubmission.core.data.source.remote.network.ApiResponse
import com.lukman.madesubmission.core.data.source.remote.response.GameResponse
import com.lukman.madesubmission.core.domain.model.Game
import com.lukman.madesubmission.core.domain.repository.IGameRepository
import com.lukman.madesubmission.core.utils.AppExecutors
import com.lukman.madesubmission.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepository @Inject constructor(
    private val remoteDataSource: com.lukman.madesubmission.core.data.source.remote.RemoteDataSource,
    private val localDataSource: com.lukman.madesubmission.core.data.source.local.LocalDataSource,
    private val appExecutors: AppExecutors
): IGameRepository {

    override fun getAllGame(): Flow<com.lukman.madesubmission.core.data.source.Resource<List<Game>>> =
        object : com.lukman.madesubmission.core.data.source.NetworkBoundResource<List<Game>, List<GameResponse>>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getAllGame().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Game>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponse>>> =
                remoteDataSource.getAllGame()

            override suspend fun saveCallResult(data: List<GameResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertGame(tourismList)
            }
        }.asFlow()

    override fun getFavoriteGame(): Flow<List<Game>> {
        return localDataSource.getFavoriteGame().map { DataMapper.mapEntitiesToDomain(it) }

    }

    override fun setFavoriteGame(tourism: Game, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteGame(tourismEntity, state) }
    }
}