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

class MovieAdapter(private val movieList: ArrayList<Result>):RecyclerView.Adapter<MovieAdapter.ShowViewHolder>() {

    fun setData(itemList:List<Result>){
        movieList.clear()
        notifyDataSetChanged()
        movieList.addAll(itemList)
    }

   inner class ShowViewHolder(private val binding: MovieListBinding):RecyclerView.ViewHolder(binding.root) {
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
                  data.vote_count
          )
          val intent = Intent(it.context, DetailActivity::class.java)
          intent.putExtra(DetailActivity.EXTRA_DATA,moveIntent)
          it.context.startActivity(intent)
      }
  }
  override fun getItemCount(): Int {
      return movieList.size
  }
}