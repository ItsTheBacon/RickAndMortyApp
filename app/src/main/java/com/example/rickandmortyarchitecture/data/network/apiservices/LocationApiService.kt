package com.example.rickandmortyarchitecture.data.network.apiservices

import com.example.rickandmortyarchitecture.data.network.dtos.LocationDto
import com.example.rickandmortyarchitecture.data.network.dtos.RickAndMortyResponseDto
import retrofit2.http.GET

interface LocationApiService {
    @GET("api/location")
    suspend fun fetchLocations(): RickAndMortyResponseDto<LocationDto>
}