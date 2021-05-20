package com.sobarna.sobarnamovies.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sobarna.sobarnamovies.adapter.MovieFavoriteAdapter
import com.sobarna.sobarnamovies.databinding.FragmentMovieFavoriteBinding
import com.sobarna.sobarnamovies.viewmodel.MovieAndShowViewModel
import com.sobarna.sobarnamovies.viewmodel.ViewModelFactory

class MovieFavoriteFragment : Fragment(){

    private var _fragmentBookmarkBinding: FragmentMovieFavoriteBinding? = null
    private val binding get() = _fragmentBookmarkBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _fragmentBookmarkBinding = FragmentMovieFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieAndShowViewModel::class.java]

            val adapter = MovieFavoriteAdapter()
            binding?.pbMovieFavoriteList?.visibility = View.VISIBLE
            viewModel.getBookmarks().observe(viewLifecycleOwner, { courses ->
                binding?.pbMovieFavoriteList?.visibility = View.GONE
                adapter.setCourses(courses)
                adapter.notifyDataSetChanged()
            })
            binding?.rvFavoriteList?.layoutManager = LinearLayoutManager(context)
            binding?.rvFavoriteList?.setHasFixedSize(true)
            binding?.rvFavoriteList?.adapter = adapter
        }
    }

}