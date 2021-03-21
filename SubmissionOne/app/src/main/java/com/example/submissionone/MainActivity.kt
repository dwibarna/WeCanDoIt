package com.example.submissionone

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionone.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel:UserViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter
    private val list = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(
            this,ViewModelProvider.NewInstanceFactory()
        ).get(UserViewModel::class.java)
   //     recyclerRetroList()
        showList()
        recycleList()
        getDetailData()

    }

    private fun getDetailData() {
        RetrofitClient.secondInstance.getPostDetail().enqueue(object :retrofit2.Callback<ArrayList<User>>{
            override fun onResponse(
                call: Call<ArrayList<User>>,
                response: Response<ArrayList<User>>
            ) {
                response.body()?.let { list.addAll(it) }
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun showLoading(state:Boolean){
        if(state){
            binding.pbListUser.visibility = View.VISIBLE
        }else{
            binding.pbListUser.visibility = View.GONE
        }
    }

    private fun showList() {
        userViewModel.getListUser().observe(this,{ userList ->
            if(userList!= null){
                adapter.setData(list)
                showLoading(true)
            }
        })

    }

   private fun recycleList() {
           binding.rvUserList.setHasFixedSize(true)
           binding.rvUserList.layoutManager = LinearLayoutManager(this)
           RetrofitClient.instance.getPosts().enqueue(object : retrofit2.Callback<ArrayList<User>> {
               override fun onResponse(
                   call: Call<ArrayList<User>>,
                   response: Response<ArrayList<User>>
               ) {
                   response.body()?.let { list.addAll(it) }
                   val adapter = UserAdapter(list)
                   binding.rvUserList.adapter = adapter
                   showLoading(false)
               }

               override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                   Toast.makeText(applicationContext, "ERROR", Toast.LENGTH_SHORT).show()

               }

           })

           val userAdapter = UserAdapter(list)
           userAdapter.setData(list)
           binding.rvUserList.adapter = userAdapter
       }

}