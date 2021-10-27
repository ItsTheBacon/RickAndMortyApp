package com.example.rickandmortyarchitecture.data.network.apiservices

import com.example.rickandmortyarchitecture.data.network.dtos.CharactersDto
import com.example.rickandmortyarchitecture.data.network.dtos.RickAndMortyResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiService {
    @GET("api/character")
    suspend fun fetchCharacters(
        @Query("page") page: Int
    ): RickAndMortyResponseDto<CharactersDto>
}