package com.example.submissionone.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submissionone.R
import com.example.submissionone.R.string.*
import com.example.submissionone.adapter.SectionPagerAdapter
import com.example.submissionone.databinding.ActivityDetailBinding
import com.example.submissionone.viewmodel.UserViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USERNAME = "extra_data"
        const val EXTRA_ID = "extra_favorite"
        const val EXTRA_AVATAR = "extra_avatar"
        private val TAB_TITLES = intArrayOf(
            mengikuti,
            pengikut
        )
    }
    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userViewModel = ViewModelProvider(
            this
        ).get(UserViewModel::class.java)

        getDetailData()
        sectionAdapterFunction()
        addAndDeleteFavorite()
    }

    private fun addAndDeleteFavorite() {
        val username = intent.getStringExtra(EXTRA_USERNAME)
        val id = intent.getIntExtra(EXTRA_ID, 0)
        val avatar = intent.getStringExtra(EXTRA_AVATAR)
        var statusFav = false

        CoroutineScope(Dispatchers.IO).launch {
            val number = userViewModel.checkFavorite(id)
            withContext(Dispatchers.Main) {
                if (number != null) {
                    if (number >0) {
                        statusFav = true
                        favoriteCheck(statusFav)
                    } else {
                        statusFav = false
                        favoriteCheck(statusFav)
                    }
                }
            }
            binding.fabFavoriteButton.setOnClickListener {
                statusFav = !statusFav
                if (statusFav) {
                    if (username != null) {
                        if (avatar != null) {
                            userViewModel.addFavoriteUser(username, id,avatar)
                        }
                    }
                    favoriteCheck(statusFav)
                } else {
                    userViewModel.deleteFavorite(id)
                    favoriteCheck(statusFav)
                }
            }
        }
    }
    private fun favoriteCheck(state: Boolean) {
        if (state) {
            binding.fabFavoriteButton.setImageResource(R.drawable.ic_baseline_favorite_24)

        } else {
            binding.fabFavoriteButton.setImageResource(R.drawable.ic_baseline_favorite_border_24)

        }
    }
    private fun showLoading(state: Boolean) {
        if (state) {
            binding.pbDetailUser.visibility = View.VISIBLE
        } else {
            binding.pbDetailUser.visibility = View.GONE
        }
    }
    private fun sectionAdapterFunction() {
        val username = intent.getStringExtra(EXTRA_USERNAME)
        val bundle = Bundle()
        bundle.putString(EXTRA_USERNAME, username)
        val sectionPagerAdapter = SectionPagerAdapter(this, bundle)
        val viewPager: ViewPager2 = binding.viewPagerDetail
        viewPager.adapter = sectionPagerAdapter
        val tabs: TabLayout = binding.tlDetail
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f
    }
    private fun getDetailData() {
        val username = intent.getStringExtra(EXTRA_USERNAME)
        val bundle = Bundle()
        bundle.putString(EXTRA_USERNAME, username)
        if (username != null) {
            userViewModel.getDetailData(username, this@DetailActivity)
            showLoading(false)
        } else {
            showLoading(true)
        }
        userViewModel.getUserDetail().observe(this, {
            if (it != null) {
                binding.apply {
                    Glide.with(this@DetailActivity)
                        .load(it.avatarUser)
                        .apply(RequestOptions().override(100, 100))
                        .into(ivAvatarAbout)
                    val companyString: String = getString(company_string) + it.companyUser
                    val locationString: String = getString(location_string) + it.locationUser
                    val repositoryString: String = getString(repository_string) + it.repositoryUser
                    val followersString: String = getString(followers_string) + it.followersUser
                    val followingString: String = getString(following_string) + it.followingUser
                    val nameString: String = getString(name_string) + it.nameUser
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

