package com.example.levl_app.presentation.car_info

import androidx.recyclerview.widget.DiffUtil
import com.example.levl_app.data.remote.pojo.posts.Post

class PostDiffCallback : DiffUtil.ItemCallback<Post>() {


    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}