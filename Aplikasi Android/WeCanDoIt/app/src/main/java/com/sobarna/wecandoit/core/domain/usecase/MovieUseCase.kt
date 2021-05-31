package com.sobarna.wecandoit.core.domain.usecase


import com.sobarna.wecandoit.core.data.Resource
import com.sobarna.wecandoit.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}