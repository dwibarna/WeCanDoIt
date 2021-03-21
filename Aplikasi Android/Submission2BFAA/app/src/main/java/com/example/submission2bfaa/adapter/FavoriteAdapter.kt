package com.example.submission2bfaa.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submission2bfaa.R
import kotlinx.android.synthetic.main.github_user.view.*
import com.example.submission2bfaa.model.Favorite
import com.example.submission2bfaa.model.User
import com.example.submission2bfaa.view.DetailActivity

class FavoriteAdapter (private val activity: Activity) :
    RecyclerView.Adapter<FavoriteAdapter.ListViewHolder>() {


    var favoriteList = ArrayList<Favorite>()
        set(listFavourite) {
            if (listFavourite.size > 0) {
                this.favoriteList.clear()
            }
            this.favoriteList.addAll(listFavourite)
            notifyDataSetChanged()
        }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(favorite: Favorite) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(favorite.avatar)
                    .apply(RequestOptions().override(100, 100))
                    .into(ivAvatar)

                tvUsername.text = favorite.username
                tvFollowingTotal.text = favorite.following
                tvFollowersTotal.text = favorite.followers
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.github_user, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return favoriteList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(favoriteList[position])

        val data = favoriteList[position]
        holder.itemView.setOnClickListener {
            val dataUser = User(
                data.username,
                data.avatar,
                data.company,
                data.location,
                data.repository,
                data.followers,
                data.following
            )
            val mIntent = Intent(it.context, DetailActivity::class.java)
            mIntent.putExtra(DetailActivity.EXTRA_DATA, dataUser)
            it.context.startActivity(mIntent)
        }
    }
}