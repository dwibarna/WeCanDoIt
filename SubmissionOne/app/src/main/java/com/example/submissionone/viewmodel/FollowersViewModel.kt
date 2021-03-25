package com.example.submissionone.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submissionone.model.FollowersUser
import com.example.submissionone.retrofitAPI.ApiRetrofit
import com.example.submissionone.retrofitAPI.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowersViewModel: ViewModel() {

    private val listFollowers  = MutableLiveData<ArrayList<FollowersUser>>()



    fun getListDataFollowers(username:String,context: Context){
        val retroInstanceFollowers = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
        retroInstanceFollowers.getFollowersAPI(username).enqueue(object : Callback<ArrayList<FollowersUser>>{
            override fun onResponse(call: Call<ArrayList<FollowersUser>>, response: Response<ArrayList<FollowersUser>>) {
                listFollowers.postValue(response.body())
                Log.v(response.toString(),"makeRecycle")
                Log.v(call.toString(),"call")
            }

            override fun onFailure(call: Call<ArrayList<FollowersUser>>, t: Throwable) {
                Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })


    }

    fun getListFollowers():LiveData<ArrayList<FollowersUser>>{
        return listFollowers
    }






}