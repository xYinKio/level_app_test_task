package com.example.levl_app

import com.example.levl_app.data.pojo.car_info.CarInfo
import com.example.levl_app.data.pojo.cars_list.CarsListItem
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

    private val client = HttpClient(CIO)

    @Test
    fun testGetCarsList() = runTest {
        val strRes = getFromRemote("http://am111.05.testing.place/api/v1/cars/list")
        assertEquals(carsListString, strRes)
        assertDoesNotThrow { Json.decodeFromString<List<CarsListItem>>(strRes) }

    }


    @Test
    fun testGetCarInfo() = runTest {
        val strRes = getFromRemote("http://am111.05.testing.place/api/v1/car/32")
        assertEquals(carInfoString, strRes)
        assertDoesNotThrow { Json.decodeFromString<CarInfo>(strRes) }
    }

    private suspend fun getFromRemote(url: String) : String{
        val response = client.get(url)
        return response.body() as String
    }


}