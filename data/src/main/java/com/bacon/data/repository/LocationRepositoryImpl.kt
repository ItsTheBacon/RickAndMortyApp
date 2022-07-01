package com.bacon.data.repository

import com.bacon.data.remote.apiservices.LocationApiService
import com.bacon.data.remote.dtos.toLocation
import com.bacon.data.remote.dtos.toResponse
import com.bacon.data.repository.base.BaseRepository
import com.bacon.domain.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val service: LocationApiService,
) : BaseRepository(), LocationRepository {
    override fun fetchLocation(page: Int) = doRequest {
        service.fetchLocations(page).toResponse().results.map {
            it.toLocation()
        }
    }
}