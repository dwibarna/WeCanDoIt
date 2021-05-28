package com.sobarna.goodapp.core.data.source.local

import com.sobarna.goodapp.core.data.source.local.entity.MovieEntity
import com.sobarna.goodapp.core.data.source.local.room.MovieDao
import io.reactivex.Flowable

class LocalDataSource private constructor(private val movieDao:MovieDao) {

    companion object {
        private var instance : LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            instance ?: synchronized(this){
                instance ?: LocalDataSource(movieDao)
            }
    }

    fun getAllMovie(): Flowable<List<MovieEntity>> = movieDao.getAllMovie()

    fun getFavoriteMovie(): Flowable<List<MovieEntity>> = movieDao.getFavoriteMovie()

    fun insertMovie(movie: List<MovieEntity>) = movieDao.insertMovie(movie)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        movieDao.updateFavoriteMovie(movie)
    }

}