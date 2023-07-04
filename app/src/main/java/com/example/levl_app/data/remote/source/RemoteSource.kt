package com.example.levl_app.data.remote.source

import com.example.levl_app.data.remote.pojo.car_info.CarInfo
import com.example.levl_app.data.remote.pojo.cars_list.CarsListItem
import com.example.levl_app.data.remote.pojo.posts.Posts

interface RemoteSource {

    suspend fun getCarsList(items: Int, page: Int) : List<CarsListItem>
    suspend fun getCarInfo(carId: Int) : CarInfo
    suspend fun getCarPosts(carId: Int) : Posts

}