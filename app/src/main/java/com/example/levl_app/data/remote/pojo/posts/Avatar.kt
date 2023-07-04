package com.example.levl_app.data.remote.pojo.posts

import kotlinx.serialization.Serializable

@Serializable
data class Avatar(
    val path: String,
    val url: String
)