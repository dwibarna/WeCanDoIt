package com.sobarna.wecandoit.domain.usecase


import com.sobarna.wecandoit.data.Resource
import com.sobarna.wecandoit.domain.model.Movie
import com.sobarna.wecandoit.domain.repository.IMovieRepository
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