package com.bacon.domain.usecase

import com.bacon.domain.repository.LocationRepository
import javax.inject.Inject

class FetchLocationsUseCase @Inject constructor(private val repository: LocationRepository) {
    operator fun invoke(page: Int) = repository.fetchLocation(page)
}