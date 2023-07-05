package com.example.levl_app.presentation.car_info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.levl_app.data.remote.pojo.car_info.CarInfo
import com.example.levl_app.data.remote.pojo.posts.Posts
import com.example.levl_app.data.remote.source.KtorRemoteSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class CarInfoViewModel : ViewModel() {

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
                _carInfo.emit(source.getCarInfo(carId))
            }
            launch {
                _posts.emit(source.getCarPosts(carId))
            }
        }
    }



}