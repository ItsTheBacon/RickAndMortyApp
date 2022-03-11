package com.example.rickandmortyarchitecture.presentation.ui.fragments.characters.detail

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.base.BaseFragment
import com.example.rickandmortyarchitecture.databinding.FragmentCharactersDetailBinding
import com.example.rickandmortyarchitecture.extensions.isVisible
import com.example.rickandmortyarchitecture.extensions.load
import com.example.rickandmortyarchitecture.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersDetailFragment :
    BaseFragment<CharactersDetailViewModel, FragmentCharactersDetailBinding>(
        R.layout.fragment_characters_detail
    ) {
    override val binding by viewBinding(FragmentCharactersDetailBinding::bind)
    override val viewModel: CharactersDetailViewModel by viewModels()
    private val args: CharactersDetailFragmentArgs by navArgs()

    override fun setupListener() {
        viewModel.fetchCharactersById(args.id)
        setUpDoneClickListener()
        setUpObserve()
    }

    private fun setUpDoneClickListener() {
        binding.clickableTextView.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setUpObserve() {
        viewModel.charactersDetailState.collectUIState {
            binding.expandImageView.setOnClickListener { _ ->
                binding.episodeListRecyclerView.isVisible(it !is UIState.Loading)
            }
            when (it) {
                is UIState.Error -> {
                    Log.e("anime", "Error Detail ${it.error}")
                }
                is UIState.Loading -> {
                    Log.e("anime", "Loading Detail $it")
                }
                is UIState.Success -> {
                    Log.e("anime", "Success Detail ${it.data}")
                    binding.apply {
                        characterDetailImage.load(it.data.image)
                        characterDetailName.text = it.data.name
                        statusTextView.text = it.data.status
                        speciesTextView.text = it.data.species
                        genderTextView.text = it.data.species
                    }
                }
            }
        }
    }
}