package com.sobarna.sobarnamovies.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sobarna.sobarnamovies.R
import com.sobarna.sobarnamovies.adapter.SectionPagerAdapter
import com.sobarna.sobarnamovies.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    companion object{
        private val TAB_TITLES = intArrayOf(
            R.string.Movie,
            R.string.TV_Show
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sectionAdapter()

    }

    private fun sectionAdapter() {
        val sectionPagerAdapter = SectionPagerAdapter(this)
        val viewPager: ViewPager2 = binding.vpMovieList
        viewPager.adapter =sectionPagerAdapter
        val tabs: TabLayout =binding.tlMovieList
        TabLayoutMediator(tabs,viewPager){ tab,position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        (activity as AppCompatActivity).supportActionBar?.elevation = 0f

    }

}