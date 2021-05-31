package com.sobarna.wecandoit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sobarna.wecandoit.domain.usecase.MovieUseCase


class HomeViewModel(useCase: MovieUseCase) : ViewModel() {
   // val useCase = useCase.getAllMovie()
    val useCase = useCase.getAllMovie().asLiveData()
}