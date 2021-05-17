package com.sobarna.sobarnamovies.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sobarna.sobarnamovies.databinding.ActivityDetailBinding
import com.sobarna.sobarnamovies.model.Result
import com.sobarna.sobarnamovies.model.ResultX

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


    private fun getData() {
        val getData = intent.getParcelableExtra<Result>(EXTRA_DATA)
        val dataShow = intent.getParcelableExtra<ResultX>(EXTRA_SHOW)
        val magicWidth = 300
        val magicHeight = 250


        if (getData?.poster_path != null){
            val imageUrl = "https://image.tmdb.org/t/p/w500${getData.poster_path}"
            Glide.with(this)
                    .load(imageUrl)
                    .apply(RequestOptions().override(magicWidth,magicHeight))
                    .into(binding.ivAvatarDetail)

            val popularity = "Popularity = ${getData.popularity}"

            binding.tvTitleDetail.text = getData.title
            binding.tvReleaseDateDetail.text = getData.release_date
            binding.tvPopularityDetail.text = popularity
            binding.tvOverviewDetail.text = getData.overview
            binding.tvAverageDetail.text = getData.vote_average.toString()
        }
        else if(dataShow?.poster_path !=null){
            val imageUrl = "https://image.tmdb.org/t/p/w500${dataShow.poster_path}"
            Glide.with(this)
                    .load(imageUrl)
                    .apply(RequestOptions().override(magicWidth,magicHeight))
                    .into(binding.ivAvatarDetail)
            val popularity = "Popularity = ${dataShow.popularity}"

            binding.tvTitleDetail.text = dataShow.name
            binding.tvReleaseDateDetail.text = dataShow.first_air_date
            binding.tvPopularityDetail.text = popularity
            binding.tvOverviewDetail.text = dataShow.overview
            binding.tvAverageDetail.text = dataShow.vote_average.toString()

        }

    }
}