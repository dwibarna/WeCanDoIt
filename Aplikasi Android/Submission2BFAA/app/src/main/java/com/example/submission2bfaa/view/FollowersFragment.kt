package com.example.submission2bfaa.view

import com.example.submission2bfaa.adapter.FollowersAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission2bfaa.R
import kotlinx.android.synthetic.main.fragment_followers.*
import com.example.submission2bfaa.model.User
import com.example.submission2bfaa.viewModel.FollowersViewModel


class FollowersFragment : Fragment() {
    private lateinit var followersViewModel: FollowersViewModel
    private lateinit var followersAdapter: FollowersAdapter

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_followers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        followersViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(
            FollowersViewModel::class.java)

        showRecyclerList()
        getDataModel()
        showList(followersAdapter)
    }

    private fun showList(adapter: FollowersAdapter) {
        activity?.let {
            followersViewModel.getListFollower().observe(it, Observer { listFollowers ->
                if (listFollowers != null){
                    adapter.setData(listFollowers)
                    showLoading(false)
                }
            })
        }
    }

    private fun getDataModel() {
        val dataUser = requireActivity().intent.getParcelableExtra(EXTRA_DATA) as User
        val userIntent = dataUser.username
        followersViewModel.dataFollowers("$userIntent",requireActivity().applicationContext)
        showLoading(true)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            pbFollowers.visibility = View.VISIBLE
        } else {
            pbFollowers.visibility = View.GONE
        }
    }

    private fun showRecyclerList(){
        etRecyclerViewFollowers.layoutManager = LinearLayoutManager(activity)
        followersAdapter = FollowersAdapter()
        followersAdapter.notifyDataSetChanged()
        etRecyclerViewFollowers.adapter = followersAdapter
    }
}

