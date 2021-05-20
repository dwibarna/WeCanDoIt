package com.sobarna.sobarnamovies.percobaan

import androidx.lifecycle.LiveData
import com.sobarna.sobarnamovies.model.FavoMovie
import com.sobarna.sobarnamovies.model.Result

class LocalDataSource private constructor(private val movieDao :MovieDao){

    companion object{
        private var INSTANCE : LocalDataSource ? = null

        fun getInstance(_movieDao:MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(_movieDao)

    }
    fun getAllMovies(): LiveData<List<Result>> = movieDao.getMovies()

    fun getFavoriteMovie(): LiveData<List<Result>> = movieDao.getAllFavoriteMovies()

    fun insertMovies(movies : List<Result>) = movieDao.insertMovies(movies)

    fun setFavoriteMovies(movies:Result,state:Boolean){
        movies.favorite = state
        movieDao.updateMovies(movies)
    }

    fun getMoviesWithId(movieId:Int) : LiveData<FavoMovie> = movieDao.getMovieById(movieId)

    fun getBookmarkedCourses():LiveData<List<Result>> {
        return movieDao.getAllFavoriteMovies()
    }

}