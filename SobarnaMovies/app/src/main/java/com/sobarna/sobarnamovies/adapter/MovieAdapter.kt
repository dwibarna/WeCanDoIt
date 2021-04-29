package com.sobarna.sobarnamovies.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sobarna.sobarnamovies.databinding.MovieListBinding
import com.sobarna.sobarnamovies.model.SobanaMovies
import com.sobarna.sobarnamovies.view.DetailActivity

class MovieAdapter(private val movieList:List<SobanaMovies>):RecyclerView.Adapter<MovieAdapter.ShowViewHolder>() {
   inner class ShowViewHolder(private val binding: MovieListBinding):RecyclerView.ViewHolder(binding.root) {
       fun bind(movie:SobanaMovies){
           val magicNumber = 100

           with(binding){
               Glide.with(itemView.context)
                   .load(movie.avatarMovie)
                   .apply(RequestOptions().override(magicNumber,magicNumber))
                   .into(ivMovieList)
               tvTitleList.text = movie.movieTitle
               tvReleaseDateList.text = movie.releaseDateMovie
           }
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val binding = MovieListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        holder.bind(movieList[position])
        val data =  movieList[position]

        holder.itemView.setOnClickListener {
            val moveIntent = SobanaMovies(
                    data.avatarMovie,
                    data.movieTitle,
                    data.releaseDateMovie,
                    data.genreMovie,
                    data.overviewMovie,
                    data.directorMovie

            )
            val intent = Intent(it.context,DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA,moveIntent)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}