package com.example.rickandmortyarchitecture.domain.repository

import com.example.rickandmortyarchitecture.common.resouce.Resource
import com.example.rickandmortyarchitecture.domain.models.LocationsModel
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    fun fetchLocation(): Flow<Resource<List<LocationsModel>>>

}