package com.bacon.data.repository

import com.bacon.data.remote.apiservices.CharacterApiService
import com.bacon.data.remote.dtos.toCharacter
import com.bacon.data.remote.dtos.toResponse
import com.bacon.data.repository.base.BaseRepository
import com.bacon.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val service: CharacterApiService,
) : BaseRepository(),
    CharacterRepository {
    override fun fetchCharacters(page: Int) = doRequest {
        service.fetchCharacters(page).toResponse().results.map {
            it.toCharacter()
        }
    }

}