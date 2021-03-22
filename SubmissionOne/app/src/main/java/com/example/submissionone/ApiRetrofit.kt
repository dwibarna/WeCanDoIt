package com.example.submissionone

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRetrofit {
    @GET("users")
    @Headers("Authorization: token efb84bdbe1810822147b62f5eaf5248d6301d5ba")
    fun getPosts(): Call<ArrayList<User>>


    fun getDetailAPI(@Query("")query:String):Call<User>

}

interface DetailRetrofit{
    @GET("users/{username}")
    @Headers("Authorization: token efb84bdbe1810822147b62f5eaf5248d6301d5ba")
    fun getDetail(@Path("username")username:String):Call<User>
}
