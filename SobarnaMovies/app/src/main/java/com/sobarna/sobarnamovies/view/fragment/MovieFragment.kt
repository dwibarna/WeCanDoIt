package com.sobarna.sobarnamovies.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sobarna.sobarnamovies.adapter.MovieAdapter
import com.sobarna.sobarnamovies.databinding.FragmentMovieBinding
import com.sobarna.sobarnamovies.model.Result
import com.sobarna.sobarnamovies.percobaan.Status
import com.sobarna.sobarnamovies.viewmodel.MovieAndShowViewModel
import com.sobarna.sobarnamovies.viewmodel.ViewModelFactory


class MovieFragment : Fragment() {

    private lateinit var factory: ViewModelFactory
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

        mutableLive()
        showLoading(true)
      //  getDataMovie(requireContext().applicationContext)


    }

    private fun mutableLive(){
        showLoading(true)
        val movieAdapter = MovieAdapter()
            movieAndShowViewModel.getMutable().observe(viewLifecycleOwner,{ movies ->
                if(movies != null){
                    when(movies.status){
                        Status.LOADING ->showLoading(true)
                        Status.SUCCESS ->{
                            showLoading(false)
                            movieAdapter.setData(movies.data)
                            movieAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR ->{
                            showLoading(false)
                            Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

        with(binding.rvMovieList){
            this.layoutManager = GridLayoutManager(activity,2)
            this.setHasFixedSize(true)
            this.adapter = movieAdapter
        }
    }

    private fun showLoading(state:Boolean){
        if(state){
            binding.pbMovieList.visibility = View.VISIBLE
        }else{
            binding.pbMovieList.visibility = View.GONE
        }
    }
/*

    private fun getDataMovie(context: Context)  {

        movieAndShowViewModel.getListMovies(context){
            movies:List<Result> ->
            showLoading(true)
            binding.rvMovieList.layoutManager = GridLayoutManager(activity,2)
            val move:ArrayList<Result> = ArrayList()
            move.addAll(movies)
            movieAdapter = MovieAdapter()
            movieAdapter.notifyDataSetChanged()
            binding.rvMovieList.adapter = movieAdapter
            showLoading(false)
        }
    }

 */
}