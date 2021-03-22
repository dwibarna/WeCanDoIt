package com.example.submissionone

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel: ViewModel() {

    private val listUser = MutableLiveData<ArrayList<User>>()
    private val listUserNonMutable = ArrayList<User>()

    fun getListUser():LiveData<ArrayList<User>>{
        return listUser
    }

    fun makeRecycleData(context: Context){
       // initRecycler()
        val retroInstance = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
        retroInstance.getPosts().enqueue(object: Callback<ArrayList<User>> {
            override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {

                listUser.postValue(response.body())
                val user = User()
                user.usernameUser?.let { detailRecycle(it,context) }

            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {

                Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
            }


        })
//        val adapter = UserAdapter(list)
  //      adapter.setData(list)
    //    binding.rvUserList.adapter = adapter

    }

     fun detailRecycle(userDetail:String,context: Context) {
         val retroInstance = RetrofitClient.getRetroInstance().create(ApiRetrofit::class.java)
         retroInstance.getDetailAPI(userDetail).enqueue(object: Callback<User> {
             override fun onResponse(call: Call<User>, response: Response<User>) {
                val user = User()
                 listUserNonMutable.add(user)
                 listUser.postValue(listUserNonMutable)
             }

             override fun onFailure(call: Call<User>, t: Throwable) {
                 Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
             }

         })
     }
}