package com.bacon.domain.repository

import com.bacon.common.resouce.Resource
import com.bacon.domain.models.LocationsModel
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    fun fetchLocation(page: Int): Flow<Resource<List<LocationsModel>>>

}