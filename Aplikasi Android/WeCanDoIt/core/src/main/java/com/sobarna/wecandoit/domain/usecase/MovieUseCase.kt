package com.sobarna.wecandoit.domain.usecase

import com.sobarna.wecandoit.data.Resource
import com.sobarna.wecandoit.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}