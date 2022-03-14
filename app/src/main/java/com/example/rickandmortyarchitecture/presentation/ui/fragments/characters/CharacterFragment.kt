package com.example.rickandmortyarchitecture.presentation.ui.fragments.characters

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.common.resouce.Resource
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.base.BaseFragment
import com.example.rickandmortyarchitecture.databinding.FragmentCharacterBinding
import com.example.rickandmortyarchitecture.extensions.getIdFromUrl
import com.example.rickandmortyarchitecture.extensions.isNetworkAvailable
import com.example.rickandmortyarchitecture.extensions.isVisible
import com.example.rickandmortyarchitecture.extensions.navigateSafely
import com.example.rickandmortyarchitecture.presentation.ui.adapters.CharactersAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class CharacterFragment :
    BaseFragment<CharactersViewModel, FragmentCharacterBinding>(R.layout.fragment_character) {
    override val binding: FragmentCharacterBinding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharactersViewModel by viewModels()
    private val adapter = CharactersAdapter(
        this::onItemLongClick,
        this::setOnItemClickListener,
        this::fetchFirstSeenIn
    )


    override fun initialize() {
        binding.characterRecycler.itemAnimator = null
        binding.characterRecycler.adapter = adapter
        adapter.addLoadStateListener {
            if (view != null) {
                binding.characterRecycler.isVisible(it.refresh is LoadState.NotLoading)
                binding.loaderCharacters.isVisible(it.refresh is LoadState.Loading)
            }
        }
    }

    override fun setupObserve() {
        setUpCharacters()

    }

    private fun setUpCharacters() {
        if (isNetworkAvailable(requireContext())) {
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.fetchCharacters().collectLatest {
                        adapter.submitData(it)
                    }
                }
            }
        }
    }

    private fun onItemLongClick(photo: String) {
        findNavController().navigateSafely(
            CharacterFragmentDirections
                .actionCharacterFragmentToDlalogFragment
                    (photo)
        )
    }

    private fun setOnItemClickListener(id: Int, name: String) {
        findNavController().navigateSafely(
            CharacterFragmentDirections
                .actionCharacterFragmentToCharactersDetailFragment(
                    id = id,
                    label = "${getString(R.string.fragment_label_detail_character)} $name",
                )
        )
    }

    private fun fetchFirstSeenIn(position: Int, episodeUrl: String) {
        viewModel.fetchEpisode(episodeUrl.getIdFromUrl()).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    Log.e("anime", "fetchFirstSeenIn:${it} ")
                }
                is Resource.Success -> {
                    Log.e("anime", "fetchFirstSeenIn:${it.data} ")
                    it.data?.let { episode ->
                        adapter.setFirstSeenIn(position, episode.name.toString())
                    }
                }
                is Resource.Error -> {
                    Log.e("anime", "fetchFirstSeenIn:${it.message} ")
                }
            }
        }
    }
}