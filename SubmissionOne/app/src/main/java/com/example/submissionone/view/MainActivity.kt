package com.example.submissionone.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionone.R
import com.example.submissionone.adapter.UserAdapter
import com.example.submissionone.databinding.ActivityMainBinding
import com.example.submissionone.model.User
import com.example.submissionone.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private var list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        showLoading(true)
        showRecyclerList()
        clickToDetail()
        getDataModel()
        showList(userAdapter)
        searchUser()

        clickToFavorite()
    }
    private fun clickToFavorite() {
        binding.btnToFavorite.setOnClickListener {
            val intent = Intent(this,FavoriteActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_settings){
            val menuIntent = Intent(this,SettingActivity::class.java)
            startActivity(menuIntent)
        }
        return super.onOptionsItemSelected(item)
    }
    private fun clickToDetail() {
        userAdapter.setOnItemClick(object : UserAdapter.OnItemClickCallBack {
            override fun onItemClick(data: User) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_USERNAME,data.usernameUser)
                intent.putExtra(DetailActivity.EXTRA_ID,data.id)
                intent.putExtra(DetailActivity.EXTRA_AVATAR,data.avatarUser)
                startActivity(intent)
            }
        })
    }
    private fun searchUser() {
        binding.svUser.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                if (query!=null){

                    binding.svUser.clearFocus()
                    userViewModel.searchUserAPI(query,applicationContext)
                    showList(userAdapter)
                    showLoading(true)
                    list.clear()
                    UserAdapter(list)


                }

                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }
    private fun getDataModel() {
        showLoading(true)
        userViewModel.getData(applicationContext)
    }
    private fun showRecyclerList() {
        showLoading(true)
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
                showLoading(false)
                adapter.setData(userList)
            }
        })
    }
}