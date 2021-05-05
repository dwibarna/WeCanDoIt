package com.sobarna.sobarnamovies.viewmodel

import androidx.lifecycle.LiveData
import com.sobarna.sobarnamovies.model.Result

interface MovieSource {

    fun getMovies(): LiveData<ArrayList<Result>>

}