package com.lukman.madesubmission.core.domain.usecase

import com.lukman.madesubmission.core.domain.model.Game
import com.lukman.madesubmission.core.domain.repository.IGameRepository
import javax.inject.Inject

class GameInteractor @Inject constructor(private val gameRepository: IGameRepository): GameUseCase {

    override fun getAllGame() = gameRepository.getAllGame()

    override fun getFavoriteGame() = gameRepository.getFavoriteGame()

    override fun setFavoriteGame(game: Game, state: Boolean) = gameRepository.setFavoriteGame(game, state)
}