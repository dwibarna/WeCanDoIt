package com.sobarna.wecandoit.domain.repository

import com.sobarna.wecandoit.data.Resource
import com.sobarna.wecandoit.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllMovies(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)

}