package com.example.rickandmortyarchitecture.presentation.ui.fragments.episodes

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.base.BaseFragment
import com.example.rickandmortyarchitecture.common.extension.ScrollListener
import com.example.rickandmortyarchitecture.databinding.FragmentEpisodesBinding
import com.example.rickandmortyarchitecture.domain.models.EpisodesModel
import com.example.rickandmortyarchitecture.presentation.state.UIState
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
        binding.episodesRv.ScrollListener(viewModel)
    }

    override fun setupObserve() {
        setUpLocations()
    }

    private fun setUpLocations() {
        viewModel.episodesState.observe(viewLifecycleOwner, {
            binding.progressBarEverything.isVisible = it is UIState.Loading
            when (it) {
                is UIState.Error -> {
                    Log.e("error", "Location:${it.error} ")
                }
                is UIState.Loading -> {
                }
                is UIState.Success -> {
                    val epList = ArrayList<EpisodesModel>(adapter.currentList)
                    epList.addAll(it.data)
                    adapter.submitList(epList)
                }
            }
        })
    }
}