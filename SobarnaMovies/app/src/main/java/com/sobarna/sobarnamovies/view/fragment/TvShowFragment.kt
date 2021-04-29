package com.sobarna.sobarnamovies.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sobarna.sobarnamovies.adapter.ShowAdapter
import com.sobarna.sobarnamovies.databinding.FragmentTvShowBinding
import com.sobarna.sobarnamovies.model.SobanaShow
import com.sobarna.sobarnamovies.viewmodel.MovieAndShowViewModel


class TvShowFragment : Fragment() {

    private lateinit var showAdapter: ShowAdapter
    private lateinit var movieAndShowViewModel: MovieAndShowViewModel
    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding!!
    private lateinit var list: List<SobanaShow>



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(inflater,container,false)
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
        getDataShow()
        showRecyclerList()
    }

    private fun getDataShow() {
       list = movieAndShowViewModel.getListShow()
        Log.d(list.size.toString(),"cek")
    }

    private fun showRecyclerList() {
        binding.rvTvShowList.layoutManager = GridLayoutManager(activity,2)
        showAdapter = ShowAdapter(list)
        showAdapter.notifyDataSetChanged()
        binding.rvTvShowList.adapter = showAdapter
    }
}