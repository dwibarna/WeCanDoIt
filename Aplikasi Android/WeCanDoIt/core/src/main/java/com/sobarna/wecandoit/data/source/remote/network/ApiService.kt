package com.sobarna.wecandoit.data.source.remote.network

import com.sobarna.wecandoit.BuildConfig
import com.sobarna.wecandoit.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("3/movie/upcoming?api_key=${BuildConfig.KEY}")
    suspend fun getListMovie(): ListMovieResponse
}