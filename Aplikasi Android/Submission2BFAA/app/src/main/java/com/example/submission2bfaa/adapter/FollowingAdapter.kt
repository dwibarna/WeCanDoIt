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
import com.example.submission2bfaa.model.Following

class FollowingAdapter : RecyclerView.Adapter<FollowingAdapter.FollowingHolder>() {
    private var followingListData =  ArrayList<Following>()
    fun setData(data: ArrayList<Following>) {
        followingListData.clear()
        followingListData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): FollowingHolder {
        val mView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_user, viewGroup, false)
        return FollowingHolder(mView)
    }

    override fun onBindViewHolder(followingHolder: FollowingHolder, position: Int) {
        followingHolder.bind(followingListData[position])


    }
    override fun getItemCount(): Int = followingListData.size

    inner class FollowingHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(following: Following) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(following.avatar)
                    .apply(RequestOptions().override(70, 70))
                    .into(ivAvatarList)
                tvUsernameList.text = following.username
                tvFollowersTotalList.text = "Followers:\n" +following.followers
                tvFollowingTotalList.text = "Following:\n"+following.dataFollowing
            }
        }
    }
}