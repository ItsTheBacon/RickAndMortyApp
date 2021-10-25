package com.example.rickandmortyarchitecture.presentation.ui.fragments.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyarchitecture.base.BaseViewModel
import com.example.rickandmortyarchitecture.domain.models.CharactersModel
import com.example.rickandmortyarchitecture.domain.usecase.CharacterUseCase
import com.example.rickandmortyarchitecture.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val useCase: CharacterUseCase) :
    BaseViewModel(
    ) {

    private val _charactersState = MutableLiveData<UIState<List<CharactersModel>>>()
    val charactersState: LiveData<UIState<List<CharactersModel>>> = _charactersState

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        subscribeTo(_charactersState) {
            useCase()
        }
    }
}