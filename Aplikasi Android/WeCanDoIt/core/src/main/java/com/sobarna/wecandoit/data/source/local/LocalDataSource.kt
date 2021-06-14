package com.sobarna.wecandoit.data.source.local



import com.sobarna.wecandoit.data.source.local.entity.MovieEntity
import com.sobarna.wecandoit.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getAllMovie(): Flow<List<MovieEntity>> = movieDao.getAllMovie()

    fun getFavoriteMovie(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

    suspend fun insertMovie(movie: List<MovieEntity>) = movieDao.insertMovie(movie)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        movieDao.updateFavoriteMovie(movie)
    }

}