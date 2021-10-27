package com.example.rickandmortyarchitecture.data.network.apiservices

import com.example.rickandmortyarchitecture.data.network.dtos.EpisodesDto
import com.example.rickandmortyarchitecture.data.network.dtos.RickAndMortyResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodesApiService {

    @GET("api/episode")
    suspend fun fetchEpisodes(
        @Query("page") page: Int
    ): RickAndMortyResponseDto<EpisodesDto>
}