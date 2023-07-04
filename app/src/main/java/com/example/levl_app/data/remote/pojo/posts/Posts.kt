package com.example.levl_app.data.remote.pojo.posts

import kotlinx.serialization.Serializable

@Serializable
data class Posts(
    val posts: List<Post>,
    val user: User
)