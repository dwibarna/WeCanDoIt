package com.sobarna.wecandoit.viewmodel

import androidx.lifecycle.ViewModel
import com.sobarna.wecandoit.domain.model.Movie
import com.sobarna.wecandoit.domain.usecase.MovieUseCase

class DetailViewModel(private val useCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus:Boolean) {
        return useCase.setFavoriteMovie(movie, newStatus)
    }
}