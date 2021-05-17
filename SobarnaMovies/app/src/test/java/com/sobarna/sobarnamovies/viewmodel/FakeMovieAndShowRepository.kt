package com.sobarna.sobarnamovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sobarna.sobarnamovies.model.MovieResponse
import com.sobarna.sobarnamovies.model.Result
import com.sobarna.sobarnamovies.model.ResultX
import com.sobarna.sobarnamovies.model.ShowResponse
import com.sobarna.sobarnamovies.sources.MovieAndShowSource
import com.sobarna.sobarnamovies.sources.RemoteDataSource

class FakeMovieAndShowRepository(private val remoteDataSource: RemoteDataSource):
    MovieAndShowSource {
    override fun getMovies(): LiveData<List<Result>> {
        val movieResult = MutableLiveData<List<Result>>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback{
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<Result>()
                for (response in movieResponse){
                    val movie = Result(
                        response.id,
                        response.original_language,
                        response.original_title,
                        response.overview,
                        response.popularity,
                        response.poster_path,
                        response.release_date,
                        response.title,
                        response.vote_average,
                        response.vote_count
                    )
                    movieList.add(movie)
                }
                movieResult.postValue(movieList)

            }

        })
        return movieResult
    }

    override fun getShows(): LiveData<List<ResultX>> {
        val showResults = MutableLiveData<List<ResultX>>()
        remoteDataSource.getShows(object : RemoteDataSource.LoadShowCallback{
            override fun onAllShowReceived(showResponse: List<ShowResponse>) {
                val showList = ArrayList<ResultX>()
                for (response in showResponse){
                    val show = ResultX(
                        response.first_air_date,
                        response.id,
                        response.name,
                        response.original_language,
                        response.original_name,
                        response.overview,
                        response.popularity,
                        response.poster_path,
                        response.vote_average,
                        response.vote_count
                    )

                    showList.add(show)
                }
                showResults.postValue(showList)
            }

        })
        return showResults
    }


}