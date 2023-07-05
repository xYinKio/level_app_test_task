package com.example.levl_app.presentation.car_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.levl_app.R
import com.example.levl_app.databinding.FragmentCarListBinding
import com.example.levl_app.presentation.car_list.adapter.CarListAdapter
import kotlinx.coroutines.launch

class CarListFragment : Fragment(R.layout.fragment_car_list) {

    private val binding: FragmentCarListBinding by viewBinding()
    private val viewModel: CarsListViewModel by viewModels()

    private val adapter by lazy { CarListAdapter(
        onCarClick = {
            findNavController().navigate(R.id.toCarInfo,
                args = Bundle().apply {
                    putInt("car_id", it)
                }
            )
        }
    ) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recycler.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.flow.collect{
                adapter.submitData(it)
            }
        }

    }


}