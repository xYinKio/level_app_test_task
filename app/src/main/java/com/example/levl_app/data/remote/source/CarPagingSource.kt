package com.example.levl_app.data.remote.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.levl_app.data.remote.pojo.cars_list.CarsListItem

class CarPagingSource(
    private val source: RemoteSource
) : PagingSource<Int, CarsListItem>() {

    override fun getRefreshKey(state: PagingState<Int, CarsListItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CarsListItem> {

        return try {
            val current = when{
                params.key == null -> 1
                params.key!! < 1 -> 1
                else -> params.key!!
            }
            val next = current + 1

            val response = source.getCarsList(params.loadSize, current)
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = next
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}