package com.example.rickandmortyarchitecture.presentation.ui.fragments.characters

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.base.BaseFragment
import com.example.rickandmortyarchitecture.common.extension.ScrollListener
import com.example.rickandmortyarchitecture.databinding.FragmentCharacterBinding
import com.example.rickandmortyarchitecture.domain.models.CharactersModel
import com.example.rickandmortyarchitecture.presentation.state.UIState
import com.example.rickandmortyarchitecture.presentation.ui.adapters.CharactersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment :
    BaseFragment<CharactersViewModel, FragmentCharacterBinding>(R.layout.fragment_character) {
    override val binding: FragmentCharacterBinding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharactersViewModel by viewModels()
    private val adapter = CharactersAdapter(this::onItemLongClick)

    override fun initialize() {
        binding.characterRecycler.adapter = adapter
        binding.characterRecycler.ScrollListener(viewModel)

    }

    override fun setupObserve() {
        setUpCharacters()
    }

    private fun setUpCharacters() {
        viewModel.charactersState.observe(viewLifecycleOwner, {
            binding.progressBarEverything.isVisible = it is UIState.Loading
            when (it) {
                is UIState.Error -> {
                    Log.e("error", "Characters:${it.error} ")
                }
                is UIState.Loading -> {
                }
                is UIState.Success -> {
                    val list = ArrayList<CharactersModel>(adapter.currentList)
                    list.addAll(it.data)
                    adapter.submitList(list)
                }
            }
        })
    }

    private fun onItemLongClick(photo: String) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToDlalogFragment(photo)
        )
    }
}