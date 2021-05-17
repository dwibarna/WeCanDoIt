package com.sobarna.sobarnamovies.retrofitapi

import com.sobarna.sobarnamovies.model.Movies
import com.sobarna.sobarnamovies.model.TvShow
import retrofit2.Call
import retrofit2.http.GET

interface ApiRetrofit {

    @GET("3/movie/upcoming?api_key=338e9f156f9f274bed38580ad4810b0f")
    fun getListMovie(): Call<Movies>

    @GET("/3/tv/popular?api_key=338e9f156f9f274bed38580ad4810b0f")
    fun getTvShow():Call<TvShow>
}