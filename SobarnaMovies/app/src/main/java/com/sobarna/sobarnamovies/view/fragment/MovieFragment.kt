package com.sobarna.sobarnamovies.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sobarna.sobarnamovies.adapter.MovieAdapter
import com.sobarna.sobarnamovies.databinding.FragmentMovieBinding
import com.sobarna.sobarnamovies.model.SobanaMovies
import com.sobarna.sobarnamovies.viewmodel.MovieAndShowViewModel


class MovieFragment : Fragment() {

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var movieAndShowViewModel: MovieAndShowViewModel
    private var _binding:FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private lateinit var list : List<SobanaMovies>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieAndShowViewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
        ).get(
                MovieAndShowViewModel::class.java
        )
        getDataMovie()
        showRecyclerList()
    }

    private fun getDataMovie() {
        list = movieAndShowViewModel.getListMovie()
    }

    private fun showRecyclerList() {
        binding.rvMovieList.layoutManager = GridLayoutManager(activity,2)
        movieAdapter = MovieAdapter(list)
        movieAdapter.notifyDataSetChanged()
        binding.rvMovieList.adapter = movieAdapter
    }
}