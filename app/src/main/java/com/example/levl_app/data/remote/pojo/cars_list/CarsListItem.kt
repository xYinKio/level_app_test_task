package com.example.levl_app.data.remote.pojo.cars_list

import kotlinx.serialization.Serializable

@Serializable
data class CarsListItem(
    val brand_id: Int,
    val brand_name: String,
    val city_name: String,
    val country_name: String,
    val engine: String,
    val engine_id: Int,
    val engine_name: String,
    val engine_volume: String,
    val for_sale: Int,
    val id: Int,
    val image: String,
    val images: List<Image>,
    val model_id: Int,
    val model_name: String,
    val name: String,
    val place_id: String?,
    val place_name: String,
    val price: Int?,
    val thumbnail: String,
    val transmission_id: Int,
    val transmission_name: String,
    val year: Int
)