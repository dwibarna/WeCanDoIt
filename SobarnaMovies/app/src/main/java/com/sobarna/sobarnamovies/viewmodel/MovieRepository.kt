package com.sobarna.sobarnamovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sobarna.sobarnamovies.model.MovieResponse
import com.sobarna.sobarnamovies.model.Result

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource): MovieSource{

    companion object{
        @Volatile
        private var instance:MovieRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MovieRepository =
                instance ?: synchronized(this){
                    instance ?: MovieRepository(remoteDataSource).apply { instance = this }
                }

    }

    override fun getMovies(): LiveData<ArrayList<Result>> {
        val movieResult = MutableLiveData<ArrayList<Result>>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback{
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<Result>()
                for (response in movieResponse){
                    val movie = Result(null,response.id,null,null,response.overview,null,response.poster_path,response.release_date,response.title,null,null)

                    movieList.add(movie)

                }
                movieResult.postValue(movieList)
            }

        })

        return movieResult

    }

}