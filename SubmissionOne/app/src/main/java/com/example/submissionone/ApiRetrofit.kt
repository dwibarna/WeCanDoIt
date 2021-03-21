package com.example.submissionone

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiRetrofit {
    @GET("users")
    @Headers("Authorization: token efb84bdbe1810822147b62f5eaf5248d6301d5ba")
    fun getPosts(): retrofit2.Call<ArrayList<User>>

}

interface ApiDetailRetrofit{
    @GET("users/{username}")
    @Headers("Authorization: token efb84bdbe1810822147b62f5eaf5248d6301d5ba")
    suspend fun findUserDetail(
        @Path("username") username:String
    )
    fun getPostDetail(): retrofit2.Call<ArrayList<User>>
}