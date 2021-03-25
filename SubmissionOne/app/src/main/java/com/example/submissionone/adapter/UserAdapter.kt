package com.example.submissionone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submissionone.model.User
import com.example.submissionone.databinding.GithubListBinding

class UserAdapter(private var listUser:ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private lateinit var onItemClickCallBack: OnItemClickCallBack

    fun setData(itemList:ArrayList<User>){
        listUser.clear()
        listUser.addAll(itemList)
        notifyDataSetChanged()

    }

    fun setOnItemClick(onItemClickCallBack: OnItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack
    }

    inner class UserViewHolder(private val binding: GithubListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User){
            with(binding){
                Glide.with(itemView.context)
                    .load(user.avatarUser)
                    .apply(RequestOptions().override(100,100))
                    .into(ivAvatarList)
                tvUsernameList.text = user.usernameUser
                binding.root.setOnClickListener {
                    onItemClickCallBack.onItemClick(user)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = GithubListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(listUser[position])
        listUser[position]

    }

    override fun getItemCount(): Int = listUser.size

    interface OnItemClickCallBack{
        fun onItemClick(data: User)
    }

}