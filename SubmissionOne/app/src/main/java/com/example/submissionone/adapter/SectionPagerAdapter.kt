package com.example.submissionone.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.submissionone.view.FollowersFragment
import com.example.submissionone.view.FollowingFragment

class SectionPagerAdapter(activity: AppCompatActivity):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment:Fragment? = null
        when(position){
            0 -> fragment = FollowersFragment()
            1 -> fragment = FollowingFragment()
        }
        return fragment as Fragment
    }

}