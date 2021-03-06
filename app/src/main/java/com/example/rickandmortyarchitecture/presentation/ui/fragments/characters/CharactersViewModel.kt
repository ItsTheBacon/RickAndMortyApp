package com.example.rickandmortyarchitecture.presentation.ui.fragments.characters

import com.bacon.domain.usecase.FetchCharactersUseCase
import com.bacon.domain.usecase.FetchEpisodesDetailUseCase
import com.example.rickandmortyarchitecture.base.BaseFetch
import com.example.rickandmortyarchitecture.base.BaseViewModel
import com.example.rickandmortyarchitecture.presentation.models.CharactersUI
import com.example.rickandmortyarchitecture.presentation.models.toUI
import com.example.rickandmortyarchitecture.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val fetchCharactersUseCase: FetchCharactersUseCase,
    private val fetchEpisodesDetailUseCase: FetchEpisodesDetailUseCase,
) : BaseViewModel(), BaseFetch {
    private val _charactersState = MutableStateFlow<UIState<List<CharactersUI>>>(UIState.Loading())
    val charactersState: StateFlow<UIState<List<CharactersUI>>> = _charactersState

    override var page: Int = 1

    init {
        fetchRick(1)
    }

    override fun fetchRick(page: Int) {
        fetchCharactersUseCase(page).collectRequest(_charactersState) { it ->
            it.map {
                it.toUI()
            }
        }
    }

    fun fetchEpisode(id: Int) =
        fetchEpisodesDetailUseCase(id)


}
