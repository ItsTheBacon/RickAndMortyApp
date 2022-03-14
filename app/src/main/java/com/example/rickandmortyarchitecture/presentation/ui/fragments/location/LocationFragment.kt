package com.example.rickandmortyarchitecture.presentation.ui.fragments.location

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.base.BaseFragment
import com.example.rickandmortyarchitecture.databinding.FragmentLocationBinding
import com.example.rickandmortyarchitecture.extensions.isVisible
import com.example.rickandmortyarchitecture.presentation.ui.adapters.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class LocationFragment :
    BaseFragment<LocationViewModel, FragmentLocationBinding>(R.layout.fragment_location) {
    override val binding: FragmentLocationBinding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val adapter = LocationAdapter()


    override fun initialize() {
        binding.locationRv.adapter = adapter
        adapter.addLoadStateListener {
            if (view != null) {
                binding.locationRv.isVisible(it.refresh is LoadState.NotLoading)
                binding.progressBarEverything.isVisible(it.refresh is LoadState.Loading)
            }
        }
    }

    override fun setupObserve() {
        setUpLocations()
    }

    private fun setUpLocations() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.fetchLocations().collectLatest {
                    adapter.submitData(it)
                }
            }
        }
    }
}