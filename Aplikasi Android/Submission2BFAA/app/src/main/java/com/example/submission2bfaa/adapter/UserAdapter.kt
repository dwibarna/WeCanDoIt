package com.example.submission2bfaa.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submission2bfaa.view.DetailActivity
import com.example.submission2bfaa.R
import kotlinx.android.synthetic.main.github_user.view.*
import com.example.submission2bfaa.model.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var listData = ArrayList<User>()
    fun setData(data: ArrayList<User>) {
        listData.clear()
        listData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): UserViewHolder {
        val mView = LayoutInflater.from(viewGroup.context).inflate(R.layout.github_user, viewGroup, false)
        return UserViewHolder(mView)
    }

    override fun onBindViewHolder(userViewHolder: UserViewHolder, position: Int) {
        userViewHolder.bind(listData[position])
        val data = listData[position]
        
        userViewHolder.itemView.setOnClickListener{
            val userIntent = User(
                "${data.username}",
                "${data.avatar}",
                "Company: ${data.company}",
                "Location: ${data.location}",
                "Repository: ${data.repository}",
                "Followers:\n${data.followers}",
                "Following:\n${data.following}"
            )
            val mIntent = Intent(it.context, DetailActivity::class.java)
            mIntent.putExtra(DetailActivity.EXTRA_DATA,userIntent)
            it.context.startActivity(mIntent)
        }
    }
    override fun getItemCount(): Int = listData.size

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(user: User) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(user.avatar)
                    .apply(RequestOptions().override(70, 70))
                    .into(ivAvatar)
                tvUsername.text = user.username
                tvFollowersTotal.text = "Followers:\n"+user.followers
                tvFollowingTotal.text = "Following:\n"+user.following
            }
        }
    }
}