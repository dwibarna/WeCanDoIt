package com.sobarna.success.viewmodel

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.sobarna.success.core.domain.usecase.MovieUseCase


class FavoriteViewModel(useCase: MovieUseCase) : ViewModel() {
    //val useCase = useCase.getFavoriteMovie()
    val useCase = LiveDataReactiveStreams.fromPublisher(useCase.getFavoriteMovie())
}