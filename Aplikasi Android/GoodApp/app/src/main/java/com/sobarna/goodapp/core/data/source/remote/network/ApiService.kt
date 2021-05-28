package com.sobarna.goodapp.core.data.source.remote.network

import com.sobarna.goodapp.BuildConfig
import com.sobarna.goodapp.core.data.source.remote.response.ListMovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("3/movie/upcoming?api_key=${BuildConfig.KEY}")
    fun getListMovie(): Call<ListMovieResponse>
}