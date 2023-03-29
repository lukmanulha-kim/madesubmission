package com.lukman.madesubmission.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.lukman.madesubmission.core.domain.usecase.GameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(gameUseCase: GameUseCase) : ViewModel() {

    val favoriteGame = gameUseCase.getFavoriteGame().asLiveData()
}