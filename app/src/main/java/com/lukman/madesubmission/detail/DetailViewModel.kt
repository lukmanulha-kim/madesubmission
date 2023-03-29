package com.lukman.madesubmission.detail

import androidx.lifecycle.ViewModel
import com.lukman.madesubmission.core.domain.model.Game
import com.lukman.madesubmission.core.domain.usecase.GameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val gameUseCase: GameUseCase) : ViewModel() {
    fun setFavoriteGame(game: Game, newStatus:Boolean) =
        gameUseCase.setFavoriteGame(game, newStatus)
}