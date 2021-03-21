package com.example.submissionone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.addAll(getUser())
        recycleList()

    }

    private fun recycleList() {
        binding.rvUserList.setHasFixedSize(true)
        binding.rvUserList.layoutManager = LinearLayoutManager(this)
        val userAdapter = UserAdapter(list)
        userAdapter.setData(list)
        binding.rvUserList.adapter = userAdapter
    }

    private fun getUser():ArrayList<User>{
        val usernameData = resources.getStringArray(R.array.username)
        val avatarData = intArrayOf(
            R.drawable.user1,
            R.drawable.user2,
            R.drawable.user3,
            R.drawable.user4,
            R.drawable.user5,
            R.drawable.user6,
            R.drawable.user7,
            R.drawable.user8,
            R.drawable.user9,
            R.drawable.user10)
        val nameData = resources.getStringArray(R.array.name)
        val locationData = resources.getStringArray(R.array.location)
        val repositoryData = resources.getStringArray(R.array.repository)
        val companyData = resources.getStringArray(R.array.company)
        val followersData = resources.getStringArray(R.array.followers)
        val followingData = resources.getStringArray(R.array.following)

        val listUser = ArrayList<User>()
        for(position in locationData.indices){
            val user = User(
                usernameData[position],
                "Name:  ${nameData[position]}",
                avatarData[position],
                "Location:  ${locationData[position]}",
                "Company:  ${companyData[position]}",
                "Repository:\n${repositoryData[position]}",
                "Followers: \n${followersData[position]}",
                "Following: \n${followingData[position]}"
            )
            listUser.add(user)
        }
        return listUser
    }
}