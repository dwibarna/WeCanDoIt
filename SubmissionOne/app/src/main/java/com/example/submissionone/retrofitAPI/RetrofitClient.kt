package com.example.submissionone.retrofitAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val URL_MAIN = "https://api.github.com/"

    fun getRetroInstance():Retrofit{
        return Retrofit.Builder()
                .baseUrl(URL_MAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}



