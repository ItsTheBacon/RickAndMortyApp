package com.example.rickandmortyarchitecture.presentation.ui.fragments.location

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bacon.data.remote.repository.LocationRepository
import com.example.rickandmortyarchitecture.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val repository: LocationRepository,
) : BaseViewModel() {
    fun fetchLocations() =
        repository.fetchLocation().cachedIn(viewModelScope)
}