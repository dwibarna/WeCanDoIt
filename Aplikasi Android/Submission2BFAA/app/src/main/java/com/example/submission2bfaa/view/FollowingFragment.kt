package com.example.submission2bfaa.view

import com.example.submission2bfaa.adapter.FollowingAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission2bfaa.R
import kotlinx.android.synthetic.main.fragment_following.*
import com.example.submission2bfaa.model.User
import com.example.submission2bfaa.viewModel.FollowingViewModel


class FollowingFragment : Fragment() {
    private lateinit var followingViewModel: FollowingViewModel
    private lateinit var followingAdapter: FollowingAdapter

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_following, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        followingViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(
            FollowingViewModel::class.java)

        showRecyclerList()
        getDataModel()
        showList(followingAdapter)
    }

    private fun showList(adapter: FollowingAdapter) {
        activity?.let {
            followingViewModel.getListFollowing().observe(it, Observer { listFollowing ->
                if (listFollowing != null){
                    adapter.setData(listFollowing)
                    showLoading(false)
                }
            })
        }
    }

    private fun getDataModel() {
        val dataUser = requireActivity().intent.getParcelableExtra(EXTRA_DATA) as User
        val userIntent = dataUser.username
        followingViewModel.dataFollowing("$userIntent",requireActivity().applicationContext)
        showLoading(true)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            pbFollowing.visibility = View.VISIBLE
        } else {
            pbFollowing.visibility = View.GONE
        }
    }

    private fun showRecyclerList(){
        etRecyclerViewFollowing.layoutManager = LinearLayoutManager(activity)
        followingAdapter = FollowingAdapter()
        followingAdapter.notifyDataSetChanged()
        etRecyclerViewFollowing.adapter = followingAdapter
    }
}

