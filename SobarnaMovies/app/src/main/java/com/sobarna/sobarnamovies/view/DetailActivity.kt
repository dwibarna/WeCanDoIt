package com.sobarna.sobarnamovies.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sobarna.sobarnamovies.databinding.ActivityDetailBinding
import com.sobarna.sobarnamovies.model.SobanaMovies
import com.sobarna.sobarnamovies.model.SobanaShow

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_SHOW = "extra_show"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
    }

    @SuppressLint("CheckResult")
    private fun getData() {
        val getData = intent.getParcelableExtra<SobanaMovies>(EXTRA_DATA)
        val dataShow = intent.getParcelableExtra<SobanaShow>(EXTRA_SHOW)
        val magicWidth = 300
        val magicHeight = 250

        if (getData?.avatarMovie != null){
            Glide.with(this)
                    .load(getData.avatarMovie)
                    .apply(RequestOptions().override(magicWidth,magicHeight))
                    .into(binding.ivAvatarDetail)

            binding.tvTitleDetail.text = getData.movieTitle
            binding.tvReleaseDateDetail.text = getData.releaseDateMovie
            binding.tvGenreDetail.text = getData.genreMovie
            binding.tvOverviewDetail.text = getData.overviewMovie
            binding.tvDirectorDetail.text = getData.directorMovie
        }else{
            Glide.with(this)
                    .load(dataShow?.avatarShow)
                    .apply(RequestOptions().override(magicWidth,magicHeight))
                    .into(binding.ivAvatarDetail)

            binding.tvTitleDetail.text = dataShow?.showTitle
            binding.tvReleaseDateDetail.text = dataShow?.ReleaseDateShow
            binding.tvGenreDetail.text = dataShow?.genreShow
            binding.tvOverviewDetail.text = dataShow?.overviewShow
            binding.tvDirectorDetail.text = dataShow?.directorShow

            val tvCreator = "Creator:"
            binding.tvDirectorOrCreator.text = tvCreator
        }

    }
}