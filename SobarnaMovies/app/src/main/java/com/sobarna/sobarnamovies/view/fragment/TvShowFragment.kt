package com.sobarna.sobarnamovies.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sobarna.sobarnamovies.adapter.ShowAdapter
import com.sobarna.sobarnamovies.databinding.FragmentTvShowBinding
import com.sobarna.sobarnamovies.model.ResultX
import com.sobarna.sobarnamovies.viewmodel.MovieAndShowViewModel
import com.sobarna.sobarnamovies.viewmodel.ViewModelFactory



class TvShowFragment : Fragment() {

    private lateinit var factory: ViewModelFactory
    private lateinit var showAdapter: ShowAdapter
    private lateinit var movieAndShowViewModel: MovieAndShowViewModel
    private var _binding:FragmentTvShowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        factory = ViewModelFactory.getInstance(requireContext().applicationContext)
        movieAndShowViewModel = ViewModelProvider(
            requireActivity(),factory
        )[MovieAndShowViewModel::class.java]

        showLoading(true)
        getDataShow(requireContext().applicationContext)
        mutableLive()
    }

    private fun mutableLive(){

            movieAndShowViewModel.getMutableShow().observe(this,{ movies ->
                val array = ArrayList<ResultX>()
                showAdapter = ShowAdapter(array)
                showAdapter.setData(movies)
                showAdapter.notifyDataSetChanged()
                showLoading(false)
            })
    }

    private fun showLoading(state:Boolean){
        if(state){
            binding.pbShowList.visibility = View.VISIBLE
        }else{
            binding.pbShowList.visibility = View.GONE
        }
    }

    private fun getDataShow(context: Context)  {
        movieAndShowViewModel.getListShows(context){

                show:List<ResultX> ->
            binding.rvTvShowList.layoutManager = GridLayoutManager(activity,2)
            val move:ArrayList<ResultX> = ArrayList()
            move.addAll(show)
            showAdapter = ShowAdapter(move)
            showAdapter.notifyDataSetChanged()
            binding.rvTvShowList.adapter = showAdapter
            showLoading(false)
        }
    }
}
