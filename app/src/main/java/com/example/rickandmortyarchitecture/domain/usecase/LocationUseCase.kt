package com.example.rickandmortyarchitecture.domain.usecase

import com.example.rickandmortyarchitecture.domain.repository.LocationRepository
import javax.inject.Inject

class LocationUseCase @Inject constructor(private val repository: LocationRepository) {
    operator fun invoke() = repository.fetchLocation()
}