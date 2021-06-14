package com.sobarna.wecandoit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sobarna.wecandoit.domain.usecase.MovieUseCase


class FavoriteViewModel(useCase: MovieUseCase) : ViewModel() {
    val useCase = useCase.getFavoriteMovie().asLiveData()
}