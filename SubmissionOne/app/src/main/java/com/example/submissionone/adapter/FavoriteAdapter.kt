package com.example.submissionone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submissionone.database.FavoriteUser
import com.example.submissionone.databinding.GithubListBinding

class FavoriteAdapter(private var favoriteList :ArrayList<FavoriteUser>)
    : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private lateinit var onItemClickCallBack: OnItemClickCallBack


    fun setOnItemClick(onItemClickCallBack: OnItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack
    }

    fun setDataFavorite(itemList: List<FavoriteUser>){
        favoriteList.clear()
        favoriteList.addAll(itemList)
        notifyDataSetChanged()
    }

    inner class FavoriteViewHolder(private val binding: GithubListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(favorite: FavoriteUser){
            with(binding){
                Glide.with(itemView.context)
                    .load(favorite.avatarUser)
                    .apply(RequestOptions().override(100,100))
                    .into(ivAvatarList)
                tvUsernameList.text = favorite.usernameUser
                binding.root.setOnClickListener {
                    onItemClickCallBack.onItemClick(favorite)
                }
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = GithubListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(favoriteList[position])
        favoriteList[position]
    }

    override fun getItemCount(): Int = favoriteList.size

    interface OnItemClickCallBack{
        fun onItemClick(data: FavoriteUser)
    }
}