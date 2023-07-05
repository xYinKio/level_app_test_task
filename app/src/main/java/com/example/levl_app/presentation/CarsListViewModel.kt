package com.example.levl_app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.levl_app.data.remote.source.KtorRemoteSource

class CarsListViewModel : ViewModel() {

    val flow = Pager(
        PagingConfig(pageSize = 30,
            initialLoadSize = 30
        )
    ){
        CarPagingSource(
            KtorRemoteSource()
        )
    }.flow.cachedIn(viewModelScope)

}