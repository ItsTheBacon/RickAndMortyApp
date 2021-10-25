package com.example.rickandmortyarchitecture.presentation.ui.fragments.episodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyarchitecture.base.BaseViewModel
import com.example.rickandmortyarchitecture.domain.models.EpisodesModel
import com.example.rickandmortyarchitecture.domain.usecase.EpisodesUseCase
import com.example.rickandmortyarchitecture.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(private val useCase: EpisodesUseCase) :
    BaseViewModel() {

    private val _episodesState = MutableLiveData<UIState<List<EpisodesModel>>>()
    val episodesState: LiveData<UIState<List<EpisodesModel>>> = _episodesState

    init {
        fetchEpisodes()
    }

    private fun fetchEpisodes() {
        subscribeTo(_episodesState) {
            useCase()
        }
    }
}