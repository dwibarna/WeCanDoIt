package com.example.submissionone.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submissionone.model.FollowingUser
import com.example.submissionone.retrofitAPI.ApiRetrofit
import com.example.submissionone.retrofitAPI.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowingViewModel:ViewModel() {



        private val listFollowing  = MutableLiveData<ArrayList<FollowingUser>>()



        fun getListDataFollowing(username:String,context: Context){
            val retroInstanceFollowing = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
            retroInstanceFollowing.getFollowingAPI(username).enqueue(object : Callback<ArrayList<FollowingUser>> {
                override fun onResponse(call: Call<ArrayList<FollowingUser>>, response: Response<ArrayList<FollowingUser>>) {
                    listFollowing.postValue(response.body())
                }

                override fun onFailure(call: Call<ArrayList<FollowingUser>>, t: Throwable) {
                    Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
                }

            })


        }

        fun getListFollowing(): LiveData<ArrayList<FollowingUser>> {
            return listFollowing
        }








}