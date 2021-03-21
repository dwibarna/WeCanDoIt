package com.example.submission2bfaa.view

import android.content.ContentValues
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submission2bfaa.Helper.FavoriteHelper
import com.example.submission2bfaa.R
import com.example.submission2bfaa.adapter.SectionPagerAdapter
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.AVATAR
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.COMPANY
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.CONTENT_URI
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.FOLLOWERS
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.FOLLOWING
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.LOCATION
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.REPOSITORY
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.USERNAME
import com.example.submission2bfaa.model.User
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var favoriteHelper: FavoriteHelper
    private var statusFav = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        favoriteHelper = FavoriteHelper.getInstance(applicationContext)
        favoriteHelper.open()

        val userList = intent.getParcelableExtra(EXTRA_DATA) as User
        val cursor = favoriteHelper.queryById(userList.username.toString())
        if (cursor.moveToNext()) {
            statusFav = true
            statusFavorite(true)
        }
        if (supportActionBar != null) {
            supportActionBar?.title = getString(R.string.detail_user)
        }
        sectionPager()
        dataIntent()
        btnFavorite.setOnClickListener(this)
    }


    private fun sectionPager() {
        val sectionPagerAdapter =
            SectionPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionPagerAdapter
        tabsLayout.setupWithViewPager(view_pager)
        supportActionBar?.elevation = 0f
    }


    private fun dataIntent() {
        val dataUser = intent.getParcelableExtra(EXTRA_DATA) as User
        Glide.with(this)
            .load(dataUser.avatar)
            .apply(RequestOptions().override(118, 149))
        .into(ivAvatarDetail)
        dtvUserName.text = dataUser.username
        dtvCompany.text = dataUser.company
        dtvLocation.text = dataUser.location
        dtvFollowing.text = dataUser.following
        dtvFollowers.text = dataUser.followers
        dtvRepository.text = dataUser.repository
    }


    private fun statusFavorite(status:Boolean){
        if (status){
            btnFavorite.setImageResource(R.drawable.ic_favorite)
        }else{
            btnFavorite.setImageResource(R.drawable.ic_favorite_add)
        }
    }

    override fun onClick(v: View?) {
        val data = intent.getParcelableExtra(EXTRA_DATA) as User
        when (v?.id) {
            R.id.btnFavorite -> {
                if (statusFav) {
                    val idUser = data.username.toString()
                    favoriteHelper.deleteById(idUser)
                    Toast.makeText(this, "deleted", Toast.LENGTH_SHORT).show()
                    statusFavorite(false)
                    statusFav = false
                } else {

                    val values = ContentValues()
                    values.put(USERNAME, data.username)
                    values.put(AVATAR, data.avatar)
                    values.put(COMPANY, data.company)
                    values.put(LOCATION, data.location)
                    values.put(REPOSITORY, data.repository)
                    values.put(FOLLOWERS, data.followers)
                    values.put(FOLLOWING, data.following)
                    statusFav = true
                    contentResolver.insert(CONTENT_URI, values)
                    Toast.makeText(this, "added", Toast.LENGTH_SHORT).show()
                    statusFavorite(true)

                }
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
