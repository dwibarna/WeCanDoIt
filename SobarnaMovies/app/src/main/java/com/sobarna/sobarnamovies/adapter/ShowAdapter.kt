package com.sobarna.sobarnamovies.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sobarna.sobarnamovies.databinding.MovieListBinding
import com.sobarna.sobarnamovies.model.SobanaShow
import com.sobarna.sobarnamovies.view.DetailActivity

class ShowAdapter(private val movieList:List<SobanaShow>): RecyclerView.Adapter<ShowAdapter.ShowViewHolder>() {
    inner class ShowViewHolder(private val binding: MovieListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(show: SobanaShow){
            val magicNumber = 100

            with(binding){
                Glide.with(itemView.context)
                    .load(show.avatarShow)
                    .apply(RequestOptions().override(magicNumber,magicNumber))
                    .into(ivMovieList)
                tvTitleList.text = show.showTitle
                tvReleaseDateList.text = show.ReleaseDateShow
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val binding = MovieListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        holder.bind(movieList[position])
        movieList[position]

        val data =  movieList[position]

        holder.itemView.setOnClickListener {
            val moveIntent = SobanaShow(
                    data.avatarShow,
                    data.showTitle,
                    data.ReleaseDateShow,
                    data.genreShow,
                    data.overviewShow,
                    data.directorShow
            )
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_SHOW,moveIntent)
            it.context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return movieList.size
    }
}