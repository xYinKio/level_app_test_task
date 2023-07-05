package com.example.levl_app

import com.example.levl_app.data.remote.pojo.car_info.CarInfo
import com.example.levl_app.data.remote.pojo.cars_list.CarsListItem
import com.example.levl_app.data.remote.pojo.posts.Posts
import com.example.levl_app.data.remote.source.BASE_URL
import com.example.levl_app.data.remote.source.KtorRemoteSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow




class ApiAndSerializationTest {

    private val source = KtorRemoteSource()

    @Test
    fun testGetCarsList() = runTest {
        val res = source.getCarsList(10, 1)
        assertEquals(Json.decodeFromString<List<CarsListItem>>(carsListString), res)
    }


    @Test
    fun testGetCarInfo() = runTest {
        assertEquals(Json.decodeFromString<CarInfo>(carInfoString), source.getCarInfo(32))
    }

    @Test
    fun testGetCarPosts() = runTest {
        assertEquals(Json.decodeFromString<Posts>(carPostsString), source.getCarPosts(32))
    }
}