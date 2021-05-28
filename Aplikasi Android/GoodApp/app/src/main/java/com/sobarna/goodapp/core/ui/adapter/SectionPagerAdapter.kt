package com.sobarna.goodapp.core.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sobarna.goodapp.view.FavoriteFragment
import com.sobarna.goodapp.view.MainActivity
import com.sobarna.goodapp.view.MovieFragment

class SectionPagerAdapter(activity: MainActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null

        when(position){
            0 -> fragment = MovieFragment()
            1 -> fragment = FavoriteFragment()
        }
        return fragment as Fragment
    }

}