package com.sobarna.wecandoit.core.data.source.remote.network


import com.sobarna.wecandoit.BuildConfig
import com.sobarna.wecandoit.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET

//${BuildConfig.KEY}
interface ApiService {
    @GET("3/movie/upcoming?api_key=${BuildConfig.KEY}")
    suspend fun getListMovie(): ListMovieResponse
}