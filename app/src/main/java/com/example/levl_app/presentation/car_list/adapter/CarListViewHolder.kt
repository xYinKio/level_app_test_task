package com.example.levl_app.presentation.car_list.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.levl_app.data.remote.pojo.cars_list.CarsListItem
import com.example.levl_app.databinding.ListItemCarBinding

class CarListViewHolder(
    private val binding: ListItemCarBinding
) : ViewHolder(binding.root) {

    fun bind(item: CarsListItem?){

        binding.info.text = item?.id?.toString()

        Glide.with(binding.root.context)
            .load(item?.image)
            .into(binding.image)


    }

}