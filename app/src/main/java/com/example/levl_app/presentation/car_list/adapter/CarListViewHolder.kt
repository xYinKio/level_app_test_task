package com.example.levl_app.presentation.car_list.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.levl_app.data.remote.pojo.cars_list.CarsListItem
import com.example.levl_app.databinding.ListItemCarBinding
import com.example.levl_app.presentation.loadFromUrl

class CarListViewHolder(
    private val binding: ListItemCarBinding,
    private val onCarClick: (carId: Int) -> Unit
) : ViewHolder(binding.root) {

    fun bind(item: CarsListItem?){

        if (item != null){
            binding.root.setOnClickListener { onCarClick(item.id) }

            binding.info.text = "${item.brand_name} ${item.model_name} ${item.engine_name} ${item.year} г."

            binding.image.loadFromUrl(item.image)
        }




    }

}