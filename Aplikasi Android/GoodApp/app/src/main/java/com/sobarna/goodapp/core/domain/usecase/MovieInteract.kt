package com.sobarna.goodapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.sobarna.goodapp.core.data.Resource
import com.sobarna.goodapp.core.domain.model.Movie
import com.sobarna.goodapp.core.domain.repository.IMovieRepository
import io.reactivex.Flowable

class MovieInteract(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovie(): Flowable<Resource<List<Movie>>> {
        return movieRepository.getAllMovies()
    }

    override fun getFavoriteMovie(): Flowable<List<Movie>> {
       return movieRepository.getFavoriteMovie()
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        return movieRepository.setFavoriteMovie(movie,state)
    }
}