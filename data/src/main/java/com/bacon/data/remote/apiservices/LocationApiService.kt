package com.bacon.data.remote.apiservices

import com.bacon.data.remote.dtos.LocationDto
import com.bacon.data.remote.dtos.RickAndMortyResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApiService {
    @GET("api/location")
    suspend fun fetchLocations(
        @Query("page") page: Int,
    ): RickAndMortyResponseDto<LocationDto>
}