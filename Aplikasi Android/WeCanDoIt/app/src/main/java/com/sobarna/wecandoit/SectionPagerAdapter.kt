package com.sobarna.wecandoit

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sobarna.wecandoit.view.FavoriteFragment
import com.sobarna.wecandoit.MainActivity
import com.sobarna.wecandoit.view.MovieFragment

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