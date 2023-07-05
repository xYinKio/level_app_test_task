package com.example.levl_app.presentation.car_info

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.levl_app.data.remote.pojo.posts.Post
import com.example.levl_app.databinding.ListItemPostBinding

class PostViewHolder(
    private val binding: ListItemPostBinding
) : ViewHolder(binding.root){

    fun bind(post: Post){

        Glide.with(binding.root.context)
            .load(post.img)
            .into(binding.image)

    }

}