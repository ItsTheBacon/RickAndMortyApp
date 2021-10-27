package com.example.rickandmortyarchitecture.presentation.ui.fragments.location

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.base.BaseFragment
import com.example.rickandmortyarchitecture.common.extension.ScrollListener
import com.example.rickandmortyarchitecture.databinding.FragmentLocationBinding
import com.example.rickandmortyarchitecture.domain.models.LocationsModel
import com.example.rickandmortyarchitecture.presentation.state.UIState
import com.example.rickandmortyarchitecture.presentation.ui.adapters.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class LocationFragment :
    BaseFragment<LocationViewModel, FragmentLocationBinding>(R.layout.fragment_location) {
    override val binding: FragmentLocationBinding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val adapter = LocationAdapter()


    override fun initialize() {
        binding.locationRv.adapter = adapter
        binding.locationRv.ScrollListener(viewModel)
    }

    override fun setupObserve() {
        setUpLocations()
    }

    private fun setUpLocations() {
        viewModel.locationState.observe(viewLifecycleOwner, {
            binding.progressBarEverything.isVisible = it is UIState.Loading
            when (it) {
                is UIState.Error -> {
                    Log.e("error", "Location:${it.error} ")
                }
                is UIState.Loading -> {
                }
                is UIState.Success -> {
                    val list = ArrayList<LocationsModel>(adapter.currentList)
                    list.addAll(it.data)
                    adapter.submitList(list)
                }
            }
        })
    }
}