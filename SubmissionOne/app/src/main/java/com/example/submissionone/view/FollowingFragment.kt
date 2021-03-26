package com.example.submissionone.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionone.adapter.FollowingAdapter
import com.example.submissionone.databinding.FragmentFollowingBinding
import com.example.submissionone.model.FollowingUser
import com.example.submissionone.viewmodel.FollowingViewModel

class FollowingFragment : Fragment() {

    private var _binding: FragmentFollowingBinding?=null
    private lateinit var followingViewModel: FollowingViewModel
    private lateinit var followingAdapter: FollowingAdapter
    private val list = ArrayList<FollowingUser>()
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFollowingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        followingViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
                FollowingViewModel::class.java
        )

        showLoading(true)
        showFollowingRecycleList()
        getDataFollowing()
        showFollowingList(followingAdapter)
    }

    private fun showLoading(state:Boolean){
        if(state){
            binding.pbFollowingUser.visibility = View.VISIBLE
        }else{
            binding.pbFollowingUser.visibility = View.GONE
        }
    }

    private fun getDataFollowing() {
        val username = arguments?.getString(DetailActivity.EXTRA_DATA).toString()
        Log.v(username,"COBA CEK")
        followingViewModel.getListDataFollowing(username,requireContext().applicationContext)
    }

    private fun showFollowingList(adapter: FollowingAdapter) {
        followingViewModel.getListFollowing().observe(viewLifecycleOwner,{ followingList ->
            if(followingList != null){
                adapter.setDataFollowing(followingList)
                showLoading(false)
            }
        })
    }

    private fun showFollowingRecycleList() {
        binding.rvFollowingList.layoutManager = LinearLayoutManager(activity)
        followingAdapter = FollowingAdapter(list)
        followingAdapter.notifyDataSetChanged()
        binding.rvFollowingList.adapter =followingAdapter
    }
}