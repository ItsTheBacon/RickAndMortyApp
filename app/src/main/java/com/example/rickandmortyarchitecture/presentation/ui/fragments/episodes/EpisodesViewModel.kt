package com.example.rickandmortyarchitecture.presentation.ui.fragments.episodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bacon.domain.models.EpisodesModel
import com.bacon.domain.usecase.EpisodesUseCase
import com.example.rickandmortyarchitecture.base.BaseFetch
import com.example.rickandmortyarchitecture.base.BaseViewModel
import com.example.rickandmortyarchitecture.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val useCase: EpisodesUseCase,
) : BaseViewModel(), BaseFetch {

    private val _episodesState = MutableLiveData<UIState<List<EpisodesModel>>>()
    val episodesState: LiveData<UIState<List<EpisodesModel>>> = _episodesState
    override var page: Int = 1

    init {
        fetchRick(1)
    }

    override fun fetchRick(page: Int) {
        subscribeTo(_episodesState) {
            useCase(page)
        }
    }


}