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
import java.util.ArrayList

class MovieFavoriteAdapter : RecyclerView.Adapter<MovieFavoriteAdapter.CourseViewHolder>() {
    private val listCourses = ArrayList<Result>()

    fun setCourses(courses: List<Result>?) {
        if (courses == null) return
        this.listCourses.clear()
        this.listCourses.addAll(courses)

        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemsBookmarkBinding = MovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemsBookmarkBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = listCourses[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCourses.size

    inner class CourseViewHolder(private val binding: MovieListBinding) : RecyclerView.ViewHolder(binding.root) {
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

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context,DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_COURSE, movie.id)
                    itemView.context.startActivity(intent)
                }

            }
        }
    }
}
