package com.example.submissionone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submissionone.databinding.GithubListBinding
import com.example.submissionone.model.FollowingUser

class FollowingAdapter(private var followingList :ArrayList<FollowingUser>)
    : RecyclerView.Adapter<FollowingAdapter.FollowingViewHolder>() {

    fun setDataFollowing(itemList: ArrayList<FollowingUser>){
        followingList.clear()
        followingList.addAll(itemList)
        notifyDataSetChanged()

    }

    inner class FollowingViewHolder(private val binding: GithubListBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(following:FollowingUser){
            with(binding){
                Glide.with(itemView.context)
                        .load(following.avatarUser)
                        .apply(RequestOptions().override(100,100))
                        .into(ivAvatarList)

                tvUsernameList.text = following.usernameUser
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingViewHolder {
        val binding = GithubListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FollowingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowingViewHolder, position: Int) {
        holder.bind(followingList[position])
        followingList[position]
    }

    override fun getItemCount(): Int = followingList.size
}