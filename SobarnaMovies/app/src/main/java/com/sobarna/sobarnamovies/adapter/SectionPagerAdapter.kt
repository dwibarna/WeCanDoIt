package com.sobarna.sobarnamovies.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sobarna.sobarnamovies.view.fragment.HomeFragment
import com.sobarna.sobarnamovies.view.fragment.MovieFragment
import com.sobarna.sobarnamovies.view.fragment.TvShowFragment

class SectionPagerAdapter(activity: HomeFragment):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment:Fragment? = null

        when(position){
            0 -> fragment = MovieFragment()
            1 -> fragment = TvShowFragment()
        }
        return fragment as Fragment
    }

}