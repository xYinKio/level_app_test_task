package com.example.levl_app.presentation.car_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.levl_app.data.remote.source.CarPagingSource
import com.example.levl_app.data.remote.source.KtorRemoteSource

class CarsListViewModel : ViewModel() { // Здесь имеет смысл вынести интерфейс при необходимости расширения

    val flow = Pager(
        PagingConfig(pageSize = 30,
            initialLoadSize = 30
        )
    ){
        CarPagingSource(
            KtorRemoteSource
        )
    }.flow.cachedIn(viewModelScope)

}