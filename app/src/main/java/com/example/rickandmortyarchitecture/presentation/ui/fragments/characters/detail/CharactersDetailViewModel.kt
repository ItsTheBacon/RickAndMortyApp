package com.example.rickandmortyarchitecture.presentation.ui.fragments.characters.detail

import com.bacon.domain.usecase.CharacterDetailUseCase
import com.example.rickandmortyarchitecture.base.BaseViewModel
import com.example.rickandmortyarchitecture.presentation.models.CharactersUI
import com.example.rickandmortyarchitecture.presentation.models.toUI
import com.example.rickandmortyarchitecture.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CharactersDetailViewModel @Inject constructor(
    private val useCase: CharacterDetailUseCase,
) : BaseViewModel() {
    private val _charactersDetailState = MutableStateFlow<UIState<CharactersUI>>(UIState.Loading())
    val charactersDetailState: StateFlow<UIState<CharactersUI>> = _charactersDetailState

    fun fetchCharactersById(id: Int) {
        useCase(id).collectRequest(_charactersDetailState) {
            it.toUI()
        }
    }
}