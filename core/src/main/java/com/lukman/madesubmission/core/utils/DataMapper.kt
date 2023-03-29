package com.lukman.madesubmission.core.utils

import com.lukman.madesubmission.core.data.source.local.entity.GamesEntity
import com.lukman.madesubmission.core.data.source.remote.response.GameResponse
import com.lukman.madesubmission.core.domain.model.Game

object DataMapper {

    fun mapResponsesToEntities(input: List<GameResponse>): List<com.lukman.madesubmission.core.data.source.local.entity.GamesEntity> {
        val gameList = ArrayList<com.lukman.madesubmission.core.data.source.local.entity.GamesEntity>()
        input.map {
            val game = com.lukman.madesubmission.core.data.source.local.entity.GamesEntity(
                gameId = it.id,
                name = it.name,
                slug = it.slug,
                released = it.released,
                background_image = it.background_image,
                rating = it.rating,
                rating_top = it.rating_top,
                isFavorite = false
            )
            gameList.add(game)
        }
        return gameList
    }

    fun mapEntitiesToDomain(input: List<com.lukman.madesubmission.core.data.source.local.entity.GamesEntity>): List<Game> =
        input.map {
            Game(
                gameId = it.gameId,
                name = it.name,
                slug = it.slug,
                released = it.released,
                background_image = it.background_image,
                rating = it.rating,
                rating_top = it.rating_top,
                isFavorite = it.isFavorite
            )
        }
    fun mapDomainToEntity(input: Game) =
        com.lukman.madesubmission.core.data.source.local.entity.GamesEntity(
            gameId = input.gameId,
            name = input.name,
            slug = input.slug,
            released = input.released,
            background_image = input.background_image,
            rating = input.rating,
            rating_top = input.rating_top,
            isFavorite = input.isFavorite
        )
}