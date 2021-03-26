package com.example.submissionone.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionone.adapter.FollowersAdapter
import com.example.submissionone.databinding.FragmentFollowersBinding
import com.example.submissionone.model.FollowersUser
import com.example.submissionone.viewmodel.FollowersViewModel


class FollowersFragment : Fragment() {

    private var _binding: FragmentFollowersBinding?=null
    private lateinit var followersViewModel: FollowersViewModel
    private lateinit var followersAdapter: FollowersAdapter
    private val list = ArrayList<FollowersUser>()
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFollowersBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        followersViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(
                FollowersViewModel::class.java
        )

        showLoading(true)
        showFollowersRecycleList()
        getDataFollowers()
        showFollowersList(followersAdapter)
    }


    private fun showLoading(state:Boolean){
        if(state){
            binding.pbFollowersUser.visibility = View.VISIBLE
        }else{
            binding.pbFollowersUser.visibility = View.GONE
        }
    }

    private fun getDataFollowers() {
        val username = arguments?.getString(DetailActivity.EXTRA_DATA).toString()
        followersViewModel.getListDataFollowers(username,requireContext().applicationContext)
    }

    private fun showFollowersList(adapter: FollowersAdapter) {
        followersViewModel.getListFollowers().observe(viewLifecycleOwner,{ followersList ->
            if(followersList != null){
                adapter.setDataFollowers(followersList)
                showLoading(false)
            }
        })
    }

    private fun showFollowersRecycleList() {
        binding.rvFollowersList.layoutManager = LinearLayoutManager(activity)
        followersAdapter = FollowersAdapter(list)
        followersAdapter.notifyDataSetChanged()
        binding.rvFollowersList.adapter =followersAdapter
    }
}