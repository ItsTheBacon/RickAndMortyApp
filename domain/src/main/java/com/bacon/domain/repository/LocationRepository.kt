package com.bacon.domain.repository

import com.bacon.common.either.Either
import com.bacon.domain.models.LocationsModel
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    fun fetchLocation(page: Int): Flow<Either<String, List<LocationsModel>>>

}