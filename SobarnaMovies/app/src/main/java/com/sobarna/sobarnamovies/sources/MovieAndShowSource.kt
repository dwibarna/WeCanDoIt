package com.sobarna.sobarnamovies.sources

import androidx.lifecycle.LiveData
import com.sobarna.sobarnamovies.model.FavoMovie
import com.sobarna.sobarnamovies.model.Result
import com.sobarna.sobarnamovies.model.ResultX
import com.sobarna.sobarnamovies.percobaan.Resource

interface MovieAndShowSource {

    fun getMovies(): LiveData<Resource<List<Result>>>

    fun getMoviesWithId(movieId : Int):LiveData<Resource<FavoMovie>>

    fun getShows():LiveData<List<ResultX>>

    fun setFavoriteMovie(movie: Result,state:Boolean)

    fun getBookmarkedCourses(): LiveData<List<Result>>

}