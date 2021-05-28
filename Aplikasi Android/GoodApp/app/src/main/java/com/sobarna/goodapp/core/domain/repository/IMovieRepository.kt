package com.sobarna.goodapp.core.domain.repository

import androidx.lifecycle.LiveData
import com.sobarna.goodapp.core.data.Resource
import com.sobarna.goodapp.core.domain.model.Movie

interface IMovieRepository {

    fun getAllMovies(): LiveData<Resource<List<Movie>>>

    fun getFavoriteMovie(): LiveData<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)

}