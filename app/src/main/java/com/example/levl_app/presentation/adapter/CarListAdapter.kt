package com.example.levl_app.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.levl_app.data.remote.pojo.cars_list.CarsListItem
import com.example.levl_app.databinding.ListItemCarBinding

class CarListAdapter : PagingDataAdapter<CarsListItem, CarListViewHolder>(CarDiffCallback()) {

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCarBinding.inflate(inflater, parent, false)
        return CarListViewHolder(binding)
    }
}



