package com.example.rickandmortyarchitecture.data.repository

import com.example.rickandmortyarchitecture.base.BaseRepository
import com.example.rickandmortyarchitecture.data.network.apiservices.LocationApiService
import com.example.rickandmortyarchitecture.data.network.dtos.toLocation
import com.example.rickandmortyarchitecture.data.network.dtos.toResponse
import com.example.rickandmortyarchitecture.domain.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(private val service: LocationApiService) :
    BaseRepository(), LocationRepository {
    override fun fetchLocation(page: Int) = doRequest {
        service.fetchLocations(page).toResponse().results.map {
            it.toLocation()
        }
    }
}