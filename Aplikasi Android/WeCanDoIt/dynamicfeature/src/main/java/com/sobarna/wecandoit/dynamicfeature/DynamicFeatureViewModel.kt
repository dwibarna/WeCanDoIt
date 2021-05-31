package com.sobarna.wecandoit.dynamicfeature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sobarna.wecandoit.domain.usecase.MovieUseCase

class DynamicFeatureViewModel(useCase: MovieUseCase): ViewModel() {
    val useCase = useCase.getFavoriteMovie().asLiveData()
}