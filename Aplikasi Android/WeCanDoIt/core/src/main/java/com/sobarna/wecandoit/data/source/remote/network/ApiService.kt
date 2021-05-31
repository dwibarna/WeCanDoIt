package com.sobarna.wecandoit.data.source.remote.network

import com.sobarna.wecandoit.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET

//${BuildConfig.KEY}
interface ApiService {
    @GET("3/movie/upcoming?api_key=338e9f156f9f274bed38580ad4810b0f")
    suspend fun getListMovie(): ListMovieResponse
}