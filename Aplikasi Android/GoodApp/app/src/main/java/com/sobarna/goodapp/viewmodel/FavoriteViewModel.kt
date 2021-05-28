package com.sobarna.goodapp.viewmodel

import androidx.lifecycle.ViewModel
import com.sobarna.goodapp.core.domain.usecase.MovieUseCase

class FavoriteViewModel(useCase: MovieUseCase) : ViewModel() {
    val useCase = useCase.getFavoriteMovie()
}