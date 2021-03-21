package com.example.submissionone

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submissionone.databinding.GithubListBinding

class UserAdapter(private var listUser:ArrayList<User>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    fun setData(itemList:ArrayList<User>){
        this.listUser = itemList

    }

    inner class UserViewHolder(private val binding: GithubListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user:User){
            with(binding){
                Glide.with(itemView.context)
                    .load(user.Avatar)
                    .apply(RequestOptions().override(100,100))
                    .into(ivAvatarList)

                tvUsernameList.text = user.Username
                tvFollowersList.text = user.Followers
                tvFollowingList.text = user.Following
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = GithubListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(listUser[position])
        val data = listUser[position]
        holder.itemView.setOnClickListener {
            val userIntent = User(
                data.Username,
                data.Name,
                data.Avatar,
                data.Location,
                data.Company,
                data.Repository,
                data.Followers,
                data.Following
            )
            val intent = Intent(it.context,AboutActivity::class.java)
            intent.putExtra(AboutActivity.EXTRA_DATA,userIntent)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listUser.size
}