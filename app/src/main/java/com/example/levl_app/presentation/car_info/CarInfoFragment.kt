package com.example.levl_app.presentation.car_info

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.levl_app.R
import com.example.levl_app.databinding.FragmentCarInfoBinding
import kotlinx.coroutines.launch

class CarInfoFragment : Fragment(R.layout.fragment_car_info) {

    private val binding: FragmentCarInfoBinding by viewBinding()
    private val adapter by lazy { PostsAdapter() }
    private val viewModel: CarInfoViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recycler.adapter = adapter

        val carId = requireArguments().getInt("car_id")
        viewModel.update(carId)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.carInfo.collect{
                Glide.with(requireContext())
                    .load(it.car.images[0].url)
                    .into(binding.image)
                val car = it.car
                binding.info.text = "${car.brand_name} ${car.model_name} ${car.engine_name} ${car.year} г."
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.posts.collect{
                adapter.submitList(it.posts)
            }
        }

    }

}