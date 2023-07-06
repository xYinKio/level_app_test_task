package com.example.levl_app.presentation.car_info

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.levl_app.data.remote.pojo.posts.Post
import com.example.levl_app.databinding.ListItemPostBinding
import com.example.levl_app.presentation.loadFromUrl

class PostViewHolder(
    private val binding: ListItemPostBinding
) : ViewHolder(binding.root){

    fun bind(post: Post){



        binding.image.loadFromUrl(post.img)
        binding.post.text = post.text
        binding.date.text = post.created_at




    }

}