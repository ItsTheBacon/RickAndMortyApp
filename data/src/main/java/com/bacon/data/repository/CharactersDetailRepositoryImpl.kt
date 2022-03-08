package com.bacon.data.repository

import com.bacon.data.remote.apiservices.CharacterDetailApiService
import com.bacon.data.remote.dtos.toCharacter
import com.bacon.data.repository.base.BaseRepository
import com.bacon.domain.repository.CharactersDetailRepository
import javax.inject.Inject

class CharactersDetailRepositoryImpl @Inject constructor(
    private val apiService: CharacterDetailApiService,
) : BaseRepository(), CharactersDetailRepository {
    override fun fetchCharacterById(id: Int) = doRequest {
        apiService.fetchCharacterById(id).toCharacter()
    }
}