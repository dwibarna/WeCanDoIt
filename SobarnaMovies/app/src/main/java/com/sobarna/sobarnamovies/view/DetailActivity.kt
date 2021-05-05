package com.sobarna.sobarnamovies.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sobarna.sobarnamovies.databinding.ActivityDetailBinding
import com.sobarna.sobarnamovies.model.Result
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
        val getData = intent.getParcelableExtra<Result>(EXTRA_DATA)
        val dataShow = intent.getParcelableExtra<SobanaShow>(EXTRA_SHOW)
        val magicWidth = 300
        val magicHeight = 250


        if (getData?.poster_path != null){
            val imageUrl :String= "https://image.tmdb.org/t/p/w500${getData.poster_path}"
            Glide.with(this)
                    .load(imageUrl)
                    .apply(RequestOptions().override(magicWidth,magicHeight))
                    .into(binding.ivAvatarDetail)


            binding.tvTitleDetail.text = getData.title
            binding.tvReleaseDateDetail.text = getData.release_date
            binding.tvGenreDetail.text = "cek"
            binding.tvOverviewDetail.text = getData.overview
            binding.tvDirectorDetail.text = getData.popularity.toString()
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