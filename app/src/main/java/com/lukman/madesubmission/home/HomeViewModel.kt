package com.lukman.madesubmission.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.lukman.madesubmission.core.domain.usecase.GameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(gameUseCase: GameUseCase) : ViewModel() {

    val game = gameUseCase.getAllGame().asLiveData()
}