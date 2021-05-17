package com.sobarna.sobarnamovies.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sobarna.sobarnamovies.databinding.MovieListBinding
import com.sobarna.sobarnamovies.model.ResultX
import com.sobarna.sobarnamovies.view.DetailActivity

class ShowAdapter(private val showList: ArrayList<ResultX>):RecyclerView.Adapter<ShowAdapter.ShowViewHolder>() {

    fun setData(itemList:List<ResultX>){
        showList.clear()
        notifyDataSetChanged()
        showList.addAll(itemList)
    }

    inner class ShowViewHolder(private val binding: MovieListBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(show: ResultX){
            val magicNumber = 100
            val imageUrl = "https://image.tmdb.org/t/p/w500"
            val poster = imageUrl + show.poster_path

            with(binding){
                Glide.with(itemView.context)
                    .load(poster)
                    .apply(RequestOptions().override(magicNumber,magicNumber))
                    .into(ivMovieList)
                tvTitleList.text = show.name
                tvReleaseDateList.text = show.first_air_date
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val binding = MovieListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        holder.bind(showList[position])
        val data =  showList[position]

        holder.itemView.setOnClickListener {

            val moveIntent = ResultX(
                data.first_air_date,
                data.id,
                data.name,
                data.original_language,
                data.original_name,
                data.overview,
                data.popularity,
                data.poster_path,
                data.vote_average,
                data.vote_count,
            )
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_SHOW,moveIntent)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return showList.size
    }
}