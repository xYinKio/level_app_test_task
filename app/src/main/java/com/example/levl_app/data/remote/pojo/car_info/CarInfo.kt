package com.example.levl_app.data.remote.pojo.car_info

import kotlinx.serialization.Serializable

@Serializable
data class CarInfo(
    val car: Car,
    val user: User
)