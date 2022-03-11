package com.example.rickandmortyarchitecture.presentation.ui.fragments.characters

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.common.resouce.Resource
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.base.BaseFragment
import com.example.rickandmortyarchitecture.databinding.FragmentCharacterBinding
import com.example.rickandmortyarchitecture.extensions.*
import com.example.rickandmortyarchitecture.presentation.state.UIState
import com.example.rickandmortyarchitecture.presentation.ui.adapters.CharactersAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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
        binding.characterRecycler.adapter = adapter
        binding.characterRecycler.scrollWithPagination(viewModel)
    }

    override fun setupObserve() {
        setUpCharacters()

    }

    private fun setUpCharacters() {
        viewModel.fetchRick(1)
        if (isNetworkAvailable(requireContext())) {
            viewModel.charactersState.collectUIState {
                when (it) {
                    is UIState.Error -> {
                        Log.e("error", "Characters:${it.error} ")
                    }
                    is UIState.Loading -> {
                        binding.shimmerLayout.startShimmer()
                    }
                    is UIState.Success -> {
                        binding.shimmerLayout.stopShimmer()
                        binding.shimmerLayout.isVisibleOrGone(false)
                        binding.characterRecycler.isVisibleOrGone(true)
                        val list = ArrayList(adapter.currentList)
                        list.addAll(it.data)
                        adapter.submitList(list)
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
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            viewModel.fetchEpisode(episodeUrl.getIdFromUrl()).collectLatest {
                when (it) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        it.data?.let { episode ->
                            adapter.setFirstSeenIn(position, episode.name.toString())
                        }
                    }
                    is Resource.Error -> {
                    }
                }
            }
        }
    }
}