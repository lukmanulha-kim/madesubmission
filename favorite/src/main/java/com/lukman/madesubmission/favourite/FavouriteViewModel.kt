package com.lukman.madesubmission.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.lukman.madesubmission.core.domain.usecase.GameUseCase


class FavouriteViewModel (gameUseCase: GameUseCase) : ViewModel() {

    val favoriteGame = gameUseCase.getFavoriteGame().asLiveData()
}