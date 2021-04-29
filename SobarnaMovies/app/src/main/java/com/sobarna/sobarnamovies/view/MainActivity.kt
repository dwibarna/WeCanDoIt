package com.sobarna.sobarnamovies.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sobarna.sobarnamovies.R
import com.sobarna.sobarnamovies.adapter.SectionPagerAdapter
import com.sobarna.sobarnamovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object{
        private val TAB_TITLES = intArrayOf(
                R.string.Movie,
                R.string.TV_Show
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sectionAdapter()
    }

    private fun sectionAdapter() {
        val sectionPagerAdapter = SectionPagerAdapter(this)
        val viewPager:ViewPager2 = binding.vpMovieList
        viewPager.adapter =sectionPagerAdapter
        val tabs:TabLayout =binding.tlMovieList
        TabLayoutMediator(tabs,viewPager){ tab,position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f
    }
}