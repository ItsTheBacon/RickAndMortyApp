package com.example.rickandmortyarchitecture.presentation.ui.fragments.characters.detail

import com.bacon.data.remote.dtos.CharactersDto
import com.bacon.data.remote.repository.CharactersDetailRepository
import com.example.rickandmortyarchitecture.base.BaseViewModel
import com.example.rickandmortyarchitecture.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CharactersDetailViewModel @Inject constructor(
    private val repositoryImpl: CharactersDetailRepository,
) : BaseViewModel() {
    private val _charactersDetailState = MutableStateFlow<UIState<CharactersDto>>(UIState.Loading())
    val charactersDetailState: StateFlow<UIState<CharactersDto>> = _charactersDetailState

    fun fetchCharactersById(id: Int) {
        _charactersDetailState.subscribeTo {
            repositoryImpl.fetchCharacterById(id)
        }
    }
}