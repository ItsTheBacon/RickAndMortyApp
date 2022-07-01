package com.example.rickandmortyarchitecture.presentation.ui.fragments.location

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.base.BaseFragment
import com.example.rickandmortyarchitecture.databinding.FragmentLocationBinding
import com.example.rickandmortyarchitecture.extensions.scrollWithPagination
import com.example.rickandmortyarchitecture.presentation.ui.adapters.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment :
    BaseFragment<LocationViewModel, FragmentLocationBinding>(R.layout.fragment_location) {
    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val adapter = LocationAdapter()


    override fun initialize() {
        binding.locationRv.adapter = adapter
        binding.locationRv.scrollWithPagination(viewModel)
    }

    override fun setupObserve() {
        setUpLocations()
    }

    private fun setUpLocations() {
        viewModel.locationsState.collectUIStateWithParameters(
            onError = {
                Log.e("error", "Location:$it ")
            },
            onSuccess = {
                val list = ArrayList(adapter.currentList)
                list.addAll(it)
                adapter.submitList(list)
            },
            onLoading = {
                it.setupViewVisibility(binding.locationRv, binding.loaderLocations, false)
            }
        )
    }
}