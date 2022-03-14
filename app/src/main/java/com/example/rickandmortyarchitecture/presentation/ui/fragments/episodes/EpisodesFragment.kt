package com.example.rickandmortyarchitecture.presentation.ui.fragments.episodes

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.base.BaseFragment
import com.example.rickandmortyarchitecture.databinding.FragmentEpisodesBinding
import com.example.rickandmortyarchitecture.extensions.isVisible
import com.example.rickandmortyarchitecture.presentation.ui.adapters.EpisodesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class EpisodesFragment :
    BaseFragment<EpisodesViewModel, FragmentEpisodesBinding>(R.layout.fragment_episodes) {
    override val binding: FragmentEpisodesBinding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel: EpisodesViewModel by viewModels()

    private val adapter = EpisodesAdapter()


    override fun initialize() {
        binding.episodesRv.adapter = adapter
        adapter.addLoadStateListener {
            if (view != null) {
                binding.episodesRv.isVisible(it.refresh is LoadState.NotLoading)
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
                viewModel.fetchEpisodes().collectLatest {
                    adapter.submitData(it)
                }
            }
        }
    }
}