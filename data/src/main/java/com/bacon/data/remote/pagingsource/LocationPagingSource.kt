package com.bacon.data.remote.pagingsource

import com.bacon.data.remote.apiservices.LocationApiService
import com.bacon.data.remote.dtos.LocationDto
import com.bacon.data.remote.repository.base.BasePagingSource

class LocationPagingSource(
    private val service: LocationApiService,
) : BasePagingSource<LocationDto>({
    service.fetchLocations(it)
})
