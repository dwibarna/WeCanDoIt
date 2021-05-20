package com.sobarna.sobarnamovies.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.sobarna.sobarnamovies.R
import com.sobarna.sobarnamovies.databinding.ActivityDetailBinding
import com.sobarna.sobarnamovies.model.Result
import com.sobarna.sobarnamovies.model.ResultX
import com.sobarna.sobarnamovies.percobaan.Status
import com.sobarna.sobarnamovies.viewmodel.MovieAndShowViewModel
import com.sobarna.sobarnamovies.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_COURSE ="extra_course"
        const val EXTRA_SHOW = "extra_show"
    }

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: MovieAndShowViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this,factory)[MovieAndShowViewModel::class.java]
       //getData()
        val getData = intent.getParcelableExtra<Result>(EXTRA_COURSE)
        if(getData !=null){
            val movieId = getData.id
            viewModel.setSelectedMovie(movieId)
            viewModel.thisData.observe(this,{observer ->
                if(observer != null){
                    when(observer.status){
                        Status.LOADING -> showLoading(true)
                        Status.SUCCESS -> if(observer.data != null){
                            showLoading(false)
                            populateMovies(observer.data.result)

                        }
                        Status.ERROR -> {
                            showLoading(false)
                            Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
    }

    private fun showLoading(state:Boolean){
        if(state){
            binding.pbDetail.visibility = View.VISIBLE
        }else{
            binding.pbDetail.visibility = View.GONE
        }
    }

    private fun setBookmarkState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_bookmark)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun getData() {

        val getData = intent.getParcelableExtra<Result>(EXTRA_COURSE)
        val dataShow = intent.getParcelableExtra<ResultX>(EXTRA_SHOW)
        val magicWidth = 300
        val magicHeight = 250



        if (getData?.poster_path != null){
            val imageUrl = "https://image.tmdb.org/t/p/w500${getData.poster_path}"
            Glide.with(this)
                    .load(imageUrl)
                    .apply(RequestOptions().override(magicWidth,magicHeight))
                    .into(binding.ivAvatarDetail)
            viewModel.setSelectedMovie(getData.id)

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

    private fun populateMovies(result: Result){
        val popularity = "Popularity = ${result.popularity}"
        val imageUrl = "https://image.tmdb.org/t/p/w500${result.poster_path}"

        binding.tvTitleDetail.text = result.title
        binding.tvReleaseDateDetail.text = result.release_date
        binding.tvPopularityDetail.text = popularity
        binding.tvOverviewDetail.text = result.overview
        binding.tvAverageDetail.text = result.vote_average.toString()

        Glide.with(this)
            .load(imageUrl)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.cinema)
                .error(R.drawable.ic_baseline_star_24))
            .into(binding.ivAvatarDetail)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail,menu)
        this.menu = menu
        viewModel.thisData.observe(this,{observer ->
            if(observer != null){
                when(observer.status){
                    Status.LOADING -> showLoading(true)

                    Status.SUCCESS -> if(observer.data != null){
                        showLoading(false)
                        val newState = observer.data.result.favorite
                        setBookmarkState(newState)
                    }
                    Status.ERROR -> {
                        showLoading(false)
                        Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_bookmark){
            viewModel.setFavorite()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}