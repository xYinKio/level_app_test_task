package com.example.levl_app.data.pojo.posts

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val author: Author,
    val comment_count: Int,
    val created_at: String,
    val id: Int,
    val img: String,
    val like_count: Int,
    val text: String
)