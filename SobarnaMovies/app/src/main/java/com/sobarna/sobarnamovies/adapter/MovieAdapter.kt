package com.sobarna.sobarnamovies.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sobarna.sobarnamovies.databinding.MovieListBinding
import com.sobarna.sobarnamovies.model.Result
import com.sobarna.sobarnamovies.view.DetailActivity

class MovieAdapter :RecyclerView.Adapter<MovieAdapter.ShowViewHolder>() {

    private var movieList = ArrayList<Result>()

    fun setData(itemList:List<Result>?){
        if(itemList == null) return
        this.movieList.clear()
        this.movieList.addAll(itemList)
    }

    class ShowViewHolder(private val binding: MovieListBinding):RecyclerView.ViewHolder(binding.root) {
       fun bind(movie: Result){
           val magicNumber = 100
           val imageUrl = "https://image.tmdb.org/t/p/w500"
           val poster = imageUrl + movie.poster_path

           with(binding){
               Glide.with(itemView.context)
                       .load(poster)
                       .apply(RequestOptions().override(magicNumber,magicNumber))
                       .into(ivMovieList)
               tvTitleList.text = movie.title
               tvReleaseDateList.text = movie.release_date
/*
               itemView.setOnClickListener {
                   val moveIntent = Result(
                       movie.id,
                       movie.original_language,
                       movie.original_title,
                       movie.overview,
                       movie.popularity,
                       movie.poster_path,
                       movie.release_date,
                       movie.title,
                       movie.vote_average,
                       movie.vote_count,
                       movie.favorite
                   )
                   val intent = Intent(itemView.context,DetailActivity::class.java)
                   intent.putExtra(DetailActivity.EXTRA_COURSE,moveIntent)
                   itemView.context.startActivity(intent)
               }

 */

           }
       }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val binding = MovieListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val hold = movieList[position]
        holder.bind(hold)

        val data =  movieList[position]

        holder.itemView.setOnClickListener {

            val moveIntent = Result(
                data.id,
                data.original_language,
                data.original_title,
                data.overview,
                data.popularity,
                data.poster_path,
                data.release_date,
                data.title,
                data.vote_average,
                data.vote_count,
                data.favorite
            )
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_COURSE,moveIntent)
            it.context.startActivity(intent)
        }
  }
  override fun getItemCount(): Int {
      return movieList.size
  }
}