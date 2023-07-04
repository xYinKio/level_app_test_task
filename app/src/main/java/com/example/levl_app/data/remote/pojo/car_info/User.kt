package com.example.levl_app.data.remote.pojo.car_info

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val about: String,
    val auto_count: Int,
    val avatar: Avatar,
    val email: String,
    val id: Int,
    val main_auto_name: String,
    val username: String
)