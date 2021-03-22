package com.example.submissionone

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel:UserViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private var list = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(
            this,ViewModelProvider.NewInstanceFactory()
        ).get(UserViewModel::class.java)

        showRecyclerList()
        getDataModel()

      showList(userAdapter)
     //   getRecycler()
      //  getDetailRecycler()
    }

    private fun getDataModel() {
        userViewModel.makeRecycleData(applicationContext)
        showLoading(true)
    }

    private fun showRecyclerList() {

        binding.rvUserList.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(list)
        userAdapter.notifyDataSetChanged()
        binding.rvUserList.adapter = userAdapter

    }

    private fun showLoading(state:Boolean){
        if(state){
            binding.pbListUser.visibility = View.VISIBLE
        }else{
            binding.pbListUser.visibility = View.GONE
        }
    }

    private fun showList(adapter: UserAdapter) {
        userViewModel.getListUser().observe(this, { userList ->
            if (userList != null){
                adapter.setData(userList)
                showLoading(false)
            }
        })
    }

}