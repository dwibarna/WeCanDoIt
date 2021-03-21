package com.example.submissionone

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val URL_MAIN = "https://api.github.com/"

    val instance:ApiRetrofit by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_MAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiRetrofit::class.java)
    }
}