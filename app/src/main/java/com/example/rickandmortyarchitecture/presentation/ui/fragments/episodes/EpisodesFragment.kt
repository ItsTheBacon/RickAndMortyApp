package com.example.rickandmortyarchitecture.presentation.ui.fragments.episodes

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.base.BaseFragment
import com.example.rickandmortyarchitecture.databinding.FragmentEpisodesBinding
import com.example.rickandmortyarchitecture.extensions.scrollWithPagination
import com.example.rickandmortyarchitecture.presentation.ui.adapters.EpisodesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodesFragment :
    BaseFragment<EpisodesViewModel, FragmentEpisodesBinding>(R.layout.fragment_episodes) {
    override val binding: FragmentEpisodesBinding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel: EpisodesViewModel by viewModels()

    private val adapter = EpisodesAdapter()

    override fun initialize() {
        binding.episodesRv.adapter = adapter
        binding.episodesRv.scrollWithPagination(viewModel)
    }

    override fun setupObserve() {
        setUpLocations()
    }

    private fun setUpLocations() {
        viewModel.episodesState.collectUIStateWithParameters(
            onError = {
                Log.e("error", "Location:$it ")
            },
            onSuccess = {
                val epList = ArrayList(adapter.currentList)
                epList.addAll(it)
                adapter.submitList(epList)
            },
            onLoading = {
                it.setupViewVisibility(binding.episodesRv, binding.loaderEpisodes, false)
            }
        )
    }
}