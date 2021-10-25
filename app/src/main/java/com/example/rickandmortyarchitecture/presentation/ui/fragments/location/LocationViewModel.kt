package com.example.rickandmortyarchitecture.presentation.ui.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyarchitecture.base.BaseViewModel
import com.example.rickandmortyarchitecture.domain.models.LocationsModel
import com.example.rickandmortyarchitecture.domain.usecase.LocationUseCase
import com.example.rickandmortyarchitecture.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(private val useCase: LocationUseCase) :
    BaseViewModel() {
    private val _locationState =
        MutableLiveData<UIState<List<LocationsModel>>>()
    val locationState: LiveData<UIState<List<LocationsModel>>> =
        _locationState


    init {
        fetchLocation()
    }

    private fun fetchLocation() {
        subscribeTo(_locationState) {
            useCase()
        }
    }

}