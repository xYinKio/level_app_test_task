package com.example.levl_app.data.pojo.car_info

import kotlinx.serialization.Serializable

@Serializable
data class CarInfo(
    val car: Car,
    val user: User
)