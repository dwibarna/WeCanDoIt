package com.sobarna.goodapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.sobarna.goodapp.core.data.Resource
import com.sobarna.goodapp.core.domain.model.Movie
import com.sobarna.goodapp.core.domain.repository.IMovieRepository

class MovieInteract(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovie(): LiveData<Resource<List<Movie>>> {
        return movieRepository.getAllMovies()
    }

    override fun getFavoriteMovie(): LiveData<List<Movie>> {
        return movieRepository.getFavoriteMovie()
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        return movieRepository.setFavoriteMovie(movie,state)
    }
}