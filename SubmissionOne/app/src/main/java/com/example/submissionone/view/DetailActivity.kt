package com.example.submissionone.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submissionone.R.string.*
import com.example.submissionone.adapter.SectionPagerAdapter
import com.example.submissionone.databinding.ActivityDetailBinding
import com.example.submissionone.viewmodel.UserViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_DATA = "extra_data"

        private val TAB_TITLES = intArrayOf(
                mengikuti,
                pengikut
        )
    }

    private lateinit var userViewModel: UserViewModel

    private lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()
        ).get(UserViewModel::class.java)


        getDetailData()
        sectionAdapterFunction()


    }


    private fun showLoading(state:Boolean){
        if(state){
            binding.pbDetailUser.visibility = View.VISIBLE
        }else{
            binding.pbDetailUser.visibility = View.GONE
        }
    }

    private fun sectionAdapterFunction() {

        val username = intent.getStringExtra(EXTRA_DATA)
        val bundle = Bundle()
        bundle.putString(EXTRA_DATA,username)

        val sectionPagerAdapter = SectionPagerAdapter(this,bundle)
        val viewPager:ViewPager2 = binding.viewPagerDetail
        viewPager.adapter = sectionPagerAdapter
        val tabs: TabLayout = binding.tlDetail
        TabLayoutMediator(tabs,viewPager){tab,position ->
            tab.text = resources.getString(TAB_TITLES[position])

        }.attach()

        supportActionBar?.elevation = 0f
    }

    private fun getDetailData() {

        val username = intent.getStringExtra(EXTRA_DATA)
        val bundle = Bundle()
        bundle.putString(EXTRA_DATA,username)


        if (username != null) {
            userViewModel.getDetailData(username,this@DetailActivity)
            showLoading(false)
        }else{
            showLoading(true)
        }

        userViewModel.getUserDetail().observe(this,{
            if (it != null){
                binding.apply {
                    Glide.with(this@DetailActivity)
                            .load(it.avatarUser)
                            .apply(RequestOptions().override(100,100))
                            .into(ivAvatarAbout)
                    val companyString:String = getString(company_string) + it.companyUser
                    val locationString:String = getString(location_string) + it.locationUser
                    val repositoryString:String = getString(repository_string) + it.repositoryUser
                    val followersString:String = getString(followers_string) + it.followersUser
                    val followingString:String = getString(following_string) + it.followingUser
                    val nameString:String = getString(name_string) + it.nameUser
                    tvUsernameAbout.text = it.usernameUser
                    tvNameAbout.text = nameString
                    tvCompanyAbout.text = companyString
                    tvLocationAbout.text = locationString
                    tvRepositoryAbout.text = repositoryString
                    tvFollowersAbout.text = followersString
                    tvFollowingAbout.text = followingString

                }
            }
        })
    }
}


