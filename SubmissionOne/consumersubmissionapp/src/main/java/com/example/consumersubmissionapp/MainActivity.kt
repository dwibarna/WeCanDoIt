package com.example.consumersubmissionapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consumersubmissionapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: ConsumerViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var favoriteAdapter: FavoriteAdapter
    private var list = ArrayList<FavoriteUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this).get(ConsumerViewModel::class.java)

        showRecycleFavoriteList()
        showFavoriteList(favoriteAdapter)
        showLoading(true)
        getConsumer()
    }

    private fun getConsumer() {
        userViewModel.getConsumer(this)
    }

    private fun showFavoriteList(adapter: FavoriteAdapter) {
            userViewModel.getConsumerList().observe(this) { userList ->
                if (userList != null) {
                    adapter.setDataFavorite(userList)
                    showLoading(false)
                }
            }
        }

        private fun showLoading(state:Boolean){
            if(state){
                binding.pbFavoriteUser.visibility = View.VISIBLE
            }else{
                binding.pbFavoriteUser.visibility = View.GONE
            }
        }



        private fun showRecycleFavoriteList() {
            binding.rvFavoriteList.layoutManager = LinearLayoutManager(this)
            favoriteAdapter = FavoriteAdapter(list)
            favoriteAdapter.notifyDataSetChanged()
            binding.rvFavoriteList.adapter = favoriteAdapter
        }

    }


