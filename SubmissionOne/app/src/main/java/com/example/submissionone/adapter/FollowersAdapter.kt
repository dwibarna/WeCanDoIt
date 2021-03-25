package com.example.submissionone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submissionone.databinding.GithubListBinding
import com.example.submissionone.model.FollowersUser

class FollowersAdapter(private var followersList :ArrayList<FollowersUser>)
    : RecyclerView.Adapter<FollowersAdapter.FollowersViewHolder>() {

    fun setDataFollowers(itemList: ArrayList<FollowersUser>){
        followersList.clear()
        followersList.addAll(itemList)
        notifyDataSetChanged()

    }

    inner class FollowersViewHolder(private val binding: GithubListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(followers: FollowersUser){
            with(binding){
                Glide.with(itemView.context)
                        .load(followers.avatarUser)
                        .apply(RequestOptions().override(100,100))
                        .into(ivAvatarList)
                tvUsernameList.text = followers.usernameUser
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowersViewHolder {
        val binding = GithubListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FollowersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowersViewHolder, position: Int) {
        holder.bind(followersList[position])
        followersList[position]
    }

    override fun getItemCount(): Int = followersList.size
}