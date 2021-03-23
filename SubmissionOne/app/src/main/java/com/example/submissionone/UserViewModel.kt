package com.example.submissionone

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel: ViewModel() {

    private lateinit var adapter: UserAdapter
    private val listUser = MutableLiveData<ArrayList<User>>()
    private val listUserNonMutable = ArrayList<User>()


    fun getListUser():LiveData<ArrayList<User>>{
        return listUser
    }

    fun makeRecycleData(context: Context){
        val retroInstance = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
        retroInstance.getPosts().enqueue(object: Callback<ArrayList<User>> {
            override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {


                listUser.postValue(response.body())
                val user = User()
                val detailUser = DetailUser()
                detailUser.usernameUser = user.usernameUser

                detailUser.usernameUser?.let { detailRecycle(it,context) }
                Log.v(response.toString(),"makeRecycle")
                Log.v(call.toString(),"call")
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {

                Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
            }


        })

    }

     fun detailRecycle(userDetail:String,context: Context) {
         val retroInstance = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
         retroInstance.getDetail(userDetail).enqueue(object: Callback<ArrayList<DetailUser>> {
             override fun onResponse(call: Call<ArrayList<DetailUser>>, response: Response<ArrayList<DetailUser>>) {
                val user = User()
                 user.usernameUser = userDetail
                 listUserNonMutable.add(user)
                 listUser.postValue(listUserNonMutable)
                 Log.v(response.toString(),"Detail")
                 Log.v(call.toString(),"Detail2")

             }

             override fun onFailure(call: Call<ArrayList<DetailUser>>, t: Throwable) {
                 Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
             }

         })
     }

    fun searchUserAPI(query:String){
        val retroInstance = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
        retroInstance.getSearchAPI(query).enqueue(object : Callback<DataSearchUser>{
            override fun onResponse(call: Call<DataSearchUser>, response: Response<DataSearchUser>) {
                if(response.isSuccessful){
                    listUser.postValue(response.body()?.items)
                }
            }

            override fun onFailure(call: Call<DataSearchUser>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }
}