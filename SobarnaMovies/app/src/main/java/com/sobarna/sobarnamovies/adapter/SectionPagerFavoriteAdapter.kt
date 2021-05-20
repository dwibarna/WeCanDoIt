package com.sobarna.sobarnamovies.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sobarna.sobarnamovies.view.fragment.*

class SectionPagerFavoriteAdapter(activity: FavoriteFragment): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null

        when(position){
            0 -> fragment = MovieFavoriteFragment()
            1 -> fragment = TvShowFragment()
        }
        return fragment as Fragment
    }

}