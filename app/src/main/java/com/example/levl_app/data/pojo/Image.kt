package com.example.levl_app.data.pojo

data class Image(
    val id: Int,
    val image100: String,
    val image500: String,
    val index: Int,
    val is_primary: Boolean,
    val size: Int,
    val thumbnail_url: String,
    val url: String
)