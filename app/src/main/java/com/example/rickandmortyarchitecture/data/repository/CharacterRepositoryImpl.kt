package com.example.rickandmortyarchitecture.data.repository

import com.example.rickandmortyarchitecture.base.BaseRepository
import com.example.rickandmortyarchitecture.data.network.apiservices.CharacterApiService
import com.example.rickandmortyarchitecture.data.network.dtos.toCharacter
import com.example.rickandmortyarchitecture.data.network.dtos.toResponse
import com.example.rickandmortyarchitecture.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val service: CharacterApiService) :
    BaseRepository(),
    CharacterRepository {
    override fun fetchCharacters() = doRequest {
        service.fetchCharacters().toResponse().results.map {
            it.toCharacter()
        }
    }

}