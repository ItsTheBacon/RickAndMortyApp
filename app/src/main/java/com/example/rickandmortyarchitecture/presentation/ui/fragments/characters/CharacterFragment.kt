package com.example.rickandmortyarchitecture.presentation.ui.fragments.characters

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.base.BaseFragment
import com.example.rickandmortyarchitecture.databinding.FragmentCharacterBinding
import com.example.rickandmortyarchitecture.extensions.*
import com.example.rickandmortyarchitecture.presentation.ui.adapters.CharactersAdapter
import dagger.hilt.android.AndroidEntryPoint

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
        binding.characterRecycler.scrollWithPagination(viewModel)
    }

    override fun setupObserve() {
        setUpCharacters()
    }

    private fun setUpCharacters() {
        if (isNetworkAvailable(requireContext())) {
            viewModel.charactersState.collectUIStateWithParameters(
                onError = {
                    Log.e("anime", "Error Characters $it")
                },
                onSuccess = {
                    binding.shimmerLayout.stopShimmer()
                    binding.shimmerLayout.isVisibleOrGone(false)
                    binding.characterRecycler.isVisibleOrGone(true)
                    val list = ArrayList(adapter.currentList)
                    list.addAll(it)
                    adapter.submitList(list)
                },
                onLoading = {
                    binding.shimmerLayout.startShimmer()
                }
            )
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
        viewModel.fetchEpisode(episodeUrl.getIdFromUrl())
        viewModel.fetchFirstSeenIn.collectUIStateWithParameters(
            onError = {
                Log.e("anime", "Error $it")
            },
            onSuccess = {
                it.let { episode ->
                    adapter.setFirstSeenIn(position, episode.name.toString())
                }
            }
        )
    }
}