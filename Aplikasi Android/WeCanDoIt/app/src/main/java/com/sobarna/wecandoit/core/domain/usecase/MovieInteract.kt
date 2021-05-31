package com.sobarna.wecandoit.core.domain.usecase


import com.sobarna.wecandoit.core.data.Resource
import com.sobarna.wecandoit.core.domain.model.Movie
import com.sobarna.wecandoit.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow


class MovieInteract(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovie(): Flow<Resource<List<Movie>>> {
       return movieRepository.getAllMovies()
    }

    override fun getFavoriteMovie(): Flow<List<Movie>> {
      return movieRepository.getFavoriteMovie()
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        return movieRepository.setFavoriteMovie(movie,state)
    }
}