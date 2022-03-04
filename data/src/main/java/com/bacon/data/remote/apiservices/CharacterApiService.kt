package com.bacon.data.remote.apiservices

import com.bacon.data.remote.dtos.CharactersDto
import com.bacon.data.remote.dtos.RickAndMortyResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiService {
    @GET("api/character")
    suspend fun fetchCharacters(
        @Query("page") page: Int,
    ): RickAndMortyResponseDto<CharactersDto>
}