package com.example.rickandmortyarchitecture.presentation.ui.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bacon.domain.models.LocationsModel
import com.bacon.domain.usecase.LocationUseCase
import com.example.rickandmortyarchitecture.base.BaseFetch
import com.example.rickandmortyarchitecture.base.BaseViewModel
import com.example.rickandmortyarchitecture.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val useCase: LocationUseCase,
) : BaseViewModel(), BaseFetch {
    private val _locationState = MutableLiveData<UIState<List<LocationsModel>>>()
    val locationState: LiveData<UIState<List<LocationsModel>>> = _locationState
    override var page: Int = 1

    init {
        fetchRick(1)
    }

    override fun fetchRick(page: Int) {
        subscribeTo(_locationState) {
            useCase(page)
        }
    }
}