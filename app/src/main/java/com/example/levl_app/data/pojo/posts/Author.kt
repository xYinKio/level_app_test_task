package com.example.levl_app.data.pojo.posts

import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val auto_count: Int,
    val avatar: Avatar,
    val id: Int,
    val main_auto_name: String,
    val username: String
)