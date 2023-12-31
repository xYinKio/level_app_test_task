package com.example.levl_app.presentation.car_info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.levl_app.data.remote.pojo.car_info.CarInfo
import com.example.levl_app.data.remote.pojo.posts.Posts
import com.example.levl_app.data.remote.source.KtorRemoteSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class CarInfoViewModel : ViewModel() { // Здесь имеет смысл вынести интерфейс при необходимости расширения

    private val source = KtorRemoteSource


    private val _carInfo = MutableSharedFlow<CarInfo>(
        replay = 1,
        extraBufferCapacity = 1
    )
    val carInfo = _carInfo.asSharedFlow()

    private val _posts = MutableSharedFlow<Posts>(
        replay = 1,
        extraBufferCapacity = 1
    )
    val posts = _posts.asSharedFlow()


    fun update(carId: Int){
        viewModelScope.launch(Dispatchers.IO){
            launch {
                runCatching { source.getCarInfo(carId) }
                    .onSuccess { _carInfo.emit(it) }
                    .onFailure { /*TODO*/ }
            }
            launch {
                runCatching { source.getCarPosts(carId) }
                    .onSuccess { _posts.emit(it)}
                    .onFailure { /*TODO*/ }

            }
        }
    }



}