package com.sobarna.sobarnamovies.sources

import androidx.lifecycle.LiveData
import com.sobarna.sobarnamovies.model.Result
import com.sobarna.sobarnamovies.model.ResultX

interface MovieAndShowSource {

    fun getMovies(): LiveData<List<Result>>

    fun getShows():LiveData<List<ResultX>>

}