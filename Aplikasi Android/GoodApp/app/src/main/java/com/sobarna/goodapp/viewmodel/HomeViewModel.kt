package com.sobarna.goodapp.viewmodel

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.sobarna.goodapp.core.domain.usecase.MovieUseCase

class HomeViewModel(useCase: MovieUseCase) : ViewModel() {
   // val useCase = useCase.getAllMovie()
    val useCase = LiveDataReactiveStreams.fromPublisher(useCase.getAllMovie())
}