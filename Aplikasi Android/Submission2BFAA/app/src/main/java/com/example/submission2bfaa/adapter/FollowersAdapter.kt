package com.example.submission2bfaa.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submission2bfaa.R
import kotlinx.android.synthetic.main.item_user.view.*
import com.example.submission2bfaa.model.Followers

class FollowersAdapter : RecyclerView.Adapter<FollowersAdapter.FollowersHolder>() {
    private var followerListData = ArrayList<Followers>()
    fun setData(data: ArrayList<Followers>) {
        followerListData.clear()
        followerListData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): FollowersHolder{
        val mView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_user, viewGroup, false)
        return FollowersHolder(mView)
    }

    override fun onBindViewHolder(followersHolder: FollowersHolder, position: Int) {
        followersHolder.bind(followerListData[position])

    }
    override fun getItemCount(): Int = followerListData.size

    inner class FollowersHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(followers: Followers) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(followers.avatar)
                    .apply(RequestOptions().override(70, 70))
                    .into(ivAvatarList)
                tvUsernameList.text = followers.username
                tvFollowersTotalList.text = "Followers:\n" +followers.followers
                tvFollowingTotalList.text = "Following:\n"+followers.dataFollowing
            }
        }
    }
}