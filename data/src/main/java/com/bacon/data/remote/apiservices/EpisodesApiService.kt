package com.bacon.data.remote.apiservices

import com.bacon.data.remote.dtos.EpisodesDto
import com.bacon.data.remote.dtos.RickAndMortyResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodesApiService {

    @GET("api/episode")
    suspend fun fetchEpisodes(
        @Query("page") page: Int,
    ): RickAndMortyResponseDto<EpisodesDto>
}