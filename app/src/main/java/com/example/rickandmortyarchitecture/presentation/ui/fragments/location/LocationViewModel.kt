package com.example.rickandmortyarchitecture.presentation.ui.fragments.location

import com.bacon.domain.usecase.FetchLocationsUseCase
import com.example.rickandmortyarchitecture.base.BaseFetch
import com.example.rickandmortyarchitecture.base.BaseViewModel
import com.example.rickandmortyarchitecture.presentation.models.LocationsUI
import com.example.rickandmortyarchitecture.presentation.models.toUI
import com.example.rickandmortyarchitecture.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val useCase: FetchLocationsUseCase,
) : BaseViewModel(), BaseFetch {
    private val _locationState = MutableStateFlow<UIState<List<LocationsUI>>>(UIState.Loading())
    val locationState: StateFlow<UIState<List<LocationsUI>>> = _locationState
    override var page: Int = 1

    init {
        fetchRick(1)
    }

    override fun fetchRick(page: Int) {
        useCase(page).collectRequest(_locationState) { it ->
            it.map {
                it.toUI()
            }
        }
    }
}