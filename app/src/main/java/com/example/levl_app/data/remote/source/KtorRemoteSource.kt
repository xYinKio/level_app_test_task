package com.example.levl_app.data.remote.source

import com.example.levl_app.data.remote.pojo.car_info.CarInfo
import com.example.levl_app.data.remote.pojo.cars_list.CarsListItem
import com.example.levl_app.data.remote.pojo.posts.Posts
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object KtorRemoteSource : RemoteSource {

    private val client = HttpClient(CIO)

    override suspend fun getCarsList(items: Int, page: Int): List<CarsListItem> {
        return get("${BASE_URL}cars/list?items=$items&page=$page")
    }

    override suspend fun getCarInfo(carId: Int): CarInfo {
        return get("${BASE_URL}car/$carId")
    }

    override suspend fun getCarPosts(carId: Int): Posts {
        return get("${BASE_URL}car/$carId/posts")
    }

    private suspend inline fun <reified T> get(url: String) : T{
        return Json.decodeFromString(getFromRemote(url))
    }


    private suspend fun getFromRemote(url: String) : String{
        val response = client.get(url)
        return response.body() as String
    }
}