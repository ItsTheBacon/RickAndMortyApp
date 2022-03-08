package com.bacon.data.remote.apiservices

import com.bacon.data.remote.dtos.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterDetailApiService {
    @GET("api/character/{id}")
    suspend fun fetchCharacterById(
        @Path("id") id: Int,
    ): CharactersDto
}