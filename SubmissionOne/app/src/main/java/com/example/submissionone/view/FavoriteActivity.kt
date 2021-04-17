package com.example.submissionone.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionone.adapter.FavoriteAdapter
import com.example.submissionone.database.FavoriteUser
import com.example.submissionone.databinding.ActivityFavoriteBinding
import com.example.submissionone.viewmodel.UserViewModel

class FavoriteActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var binding:ActivityFavoriteBinding
    private lateinit var favoriteAdapter: FavoriteAdapter
    private var list = ArrayList<FavoriteUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        showRecycleFavoriteList()
        showFavoriteList(favoriteAdapter)
        showLoading(true)
        onClickDetail()
    }
    private fun onClickDetail() {
        favoriteAdapter.setOnItemClick(object : FavoriteAdapter.OnItemClickCallBack {
            override fun onItemClick(data: FavoriteUser) {
                val intent = Intent(this@FavoriteActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_USERNAME,data.usernameUser)
                intent.putExtra(DetailActivity.EXTRA_ID,data.id)
                intent.putExtra(DetailActivity.EXTRA_AVATAR,data.avatarUser)
                startActivity(intent)
            }
        })
    }
    private fun showFavoriteList(adapter: FavoriteAdapter) {
        userViewModel.getFavoriteUser()?.observe(this, { userList ->
            if (userList != null){
                adapter.setDataFavorite(userList)
                showLoading(false)
            }
        })
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