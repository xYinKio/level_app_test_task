package com.example.levl_app.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.levl_app.data.remote.pojo.cars_list.CarsListItem

class CarDiffCallback : DiffUtil.ItemCallback<CarsListItem>() {

    override fun areItemsTheSame(oldItem: CarsListItem, newItem: CarsListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CarsListItem, newItem: CarsListItem): Boolean {
        return oldItem == newItem
    }
}