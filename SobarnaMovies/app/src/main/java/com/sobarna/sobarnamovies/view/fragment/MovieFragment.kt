package com.sobarna.sobarnamovies.view.fragment

import android.content.Context
import android.graphics.Movie
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sobarna.sobarnamovies.adapter.MovieAdapter
import com.sobarna.sobarnamovies.databinding.FragmentMovieBinding
import com.sobarna.sobarnamovies.model.Result
import com.sobarna.sobarnamovies.viewmodel.MovieAndShowViewModel
import com.sobarna.sobarnamovies.viewmodel.ViewModelFactory


class MovieFragment : Fragment() {

    private lateinit var factory: ViewModelFactory
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var movieAndShowViewModel: MovieAndShowViewModel
    private var _binding:FragmentMovieBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        factory = ViewModelFactory.getInstance(requireContext().applicationContext)
        movieAndShowViewModel = ViewModelProvider(
                requireActivity(),factory
        )[MovieAndShowViewModel::class.java]
        showLoading(true)
        getDataMovie(requireContext().applicationContext)
        mutableLive()

    }

    private fun mutableLive(){
            movieAndShowViewModel.getMutable().observe(this,{ movies ->
                val arrayList = ArrayList<Result>()
                movieAdapter = MovieAdapter(arrayList)
                movieAdapter.setData(movies)
                movieAdapter.notifyDataSetChanged()
                showLoading(false)
            })
    }

    private fun showLoading(state:Boolean){
        if(state){
            binding.pbMovieList.visibility = View.VISIBLE
        }else{
            binding.pbMovieList.visibility = View.GONE
        }
    }


    private fun getDataMovie(context: Context)  {
        movieAndShowViewModel.getListMovies(context){

            movies:List<Result> ->
            binding.rvMovieList.layoutManager = GridLayoutManager(activity,2)
            val move:ArrayList<Result> = ArrayList()
            move.addAll(movies)
            movieAdapter = MovieAdapter(move)
            movieAdapter.notifyDataSetChanged()
            binding.rvMovieList.adapter = movieAdapter
            showLoading(false)
        }
    }
}