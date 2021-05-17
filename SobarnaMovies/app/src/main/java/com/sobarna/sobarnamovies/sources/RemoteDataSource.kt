package com.sobarna.sobarnamovies.sources

import android.os.Handler
import android.os.Looper
import com.sobarna.sobarnamovies.model.MovieResponse
import com.sobarna.sobarnamovies.model.ShowResponse
import com.sobarna.sobarnamovies.utils.EspressoIdlingResource
import com.sobarna.sobarnamovies.utils.JsonHelper


class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    private val handler = Handler(Looper.getMainLooper())

    companion object{
        private const val SERVICE_LATENCY:Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
                instance ?: synchronized(this){
                    instance ?: RemoteDataSource(helper).apply { instance = this }
                }
    }

    fun getMovies(callback:LoadMoviesCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllMoviesReceived(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY)
    }

    fun getShows(callback: LoadShowCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllShowReceived(jsonHelper.loadShows())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY)
    }

    interface LoadMoviesCallback{
        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadShowCallback{
        fun onAllShowReceived(showResponse: List<ShowResponse>)
    }
}