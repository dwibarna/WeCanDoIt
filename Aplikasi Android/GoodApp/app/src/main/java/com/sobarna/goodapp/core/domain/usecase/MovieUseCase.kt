package com.sobarna.goodapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.sobarna.goodapp.core.data.Resource
import com.sobarna.goodapp.core.domain.model.Movie

interface MovieUseCase {
    fun getAllMovie(): LiveData<Resource<List<Movie>>>
    fun getFavoriteMovie(): LiveData<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}