package com.sobarna.sobarnamovies.viewmodel

import android.os.Handler
import android.os.Looper
import com.sobarna.sobarnamovies.model.MovieResponse


class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    private val handler = Handler(Looper.getMainLooper())

    companion object{
        private const val SERVICE_LATENCY:Long = 2000

        @Volatile
        private var instance:RemoteDataSource? = null

        fun getInstance(helper: JsonHelper):RemoteDataSource =
                instance ?: synchronized(this){
                    instance ?: RemoteDataSource(helper).apply { instance = this }
                }
    }

   // fun getMovies():List<MovieResponse> = jsonHelper.loadMovies()

    fun getMovies(callback:LoadMoviesCallback){
        handler.postDelayed({callback.onAllMoviesReceived(jsonHelper.loadMovies())}, SERVICE_LATENCY)
    }


    interface LoadMoviesCallback{
        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
    }
}