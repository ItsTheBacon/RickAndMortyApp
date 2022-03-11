package com.example.rickandmortyarchitecture.presentation.ui.fragments.episodes

import com.bacon.domain.usecase.FetchEpisodesUseCase
import com.example.rickandmortyarchitecture.base.BaseFetch
import com.example.rickandmortyarchitecture.base.BaseViewModel
import com.example.rickandmortyarchitecture.presentation.models.EpisodesUI
import com.example.rickandmortyarchitecture.presentation.models.toUI
import com.example.rickandmortyarchitecture.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val useCase: FetchEpisodesUseCase,
) : BaseViewModel(), BaseFetch {

    private val _episodesState = MutableStateFlow<UIState<List<EpisodesUI>>>(UIState.Loading())
    val episodesState: StateFlow<UIState<List<EpisodesUI>>> = _episodesState
    override var page: Int = 1

    init {
        fetchRick(1)
    }

    override fun fetchRick(page: Int) {
        useCase(page).collectRequest(_episodesState) { it ->
            it.map {
                it.toUI()
            }
        }
    }


}