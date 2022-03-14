package com.bacon.data.remote.repository

import com.bacon.data.remote.apiservices.LocationApiService
import com.bacon.data.remote.pagingsource.LocationPagingSource
import com.bacon.data.remote.repository.base.BaseRepository
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val service: LocationApiService,
) : BaseRepository() {
    fun fetchLocation() = doRequestWithPaging(LocationPagingSource(service))
}