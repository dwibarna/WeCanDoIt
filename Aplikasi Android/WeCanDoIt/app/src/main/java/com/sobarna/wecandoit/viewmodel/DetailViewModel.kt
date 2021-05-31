package com.sobarna.wecandoit.viewmodel

import androidx.lifecycle.ViewModel
import com.sobarna.wecandoit.domain.model.Movie
import com.sobarna.wecandoit.domain.usecase.MovieUseCase

class DetailViewModel(private val useCase: MovieUseCase) : ViewModel() {
    fun setFavoriteTourism(movie: Movie, newStatus:Boolean) =
        useCase.setFavoriteMovie(movie, newStatus)
}