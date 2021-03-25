package com.example.submissionone.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submissionone.model.DataSearchUser
import com.example.submissionone.model.DetailUser
import com.example.submissionone.model.User
import com.example.submissionone.retrofitAPI.ApiRetrofit
import com.example.submissionone.retrofitAPI.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel: ViewModel() {

    private val detailUserList = MutableLiveData<DetailUser>()
    private val listUser = MutableLiveData<ArrayList<User>>()

    fun getListUser():LiveData<ArrayList<User>>{
        return listUser
    }

    fun getUserDetail():LiveData<DetailUser>{
        return detailUserList
    }

    fun getData(context: Context){
        val retroInstance = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
        retroInstance.getPosts().enqueue(object: Callback<ArrayList<User>> {
            override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                listUser.postValue(response.body())
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {

                Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

    }

     fun getDetailData(username:String, context: Context) {
         val retroInstanceDetail = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
         retroInstanceDetail.getDetail(username).enqueue(object: Callback<DetailUser> {
             override fun onResponse(call: Call<DetailUser>, response: Response<DetailUser>) {

                 if (response.isSuccessful) {
                     detailUserList.postValue(response.body())
                 }
             }

             override fun onFailure(call: Call<DetailUser>, t: Throwable) {
                 Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
             }
         })
     }

    fun searchUserAPI(query:String,context: Context){
        val retroInstance = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
        retroInstance.getSearchAPI(query).enqueue(object : Callback<DataSearchUser>{
            override fun onResponse(call: Call<DataSearchUser>, response: Response<DataSearchUser>) {
                if(response.isSuccessful){
                    listUser.postValue(response.body()?.items)
                }
            }
            override fun onFailure(call: Call<DataSearchUser>, t: Throwable) {
                Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}