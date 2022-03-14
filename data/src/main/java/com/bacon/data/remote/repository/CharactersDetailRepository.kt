package com.bacon.data.remote.repository

import com.bacon.data.remote.apiservices.CharacterDetailApiService
import com.bacon.data.remote.repository.base.BaseRepository
import javax.inject.Inject

class CharactersDetailRepository @Inject constructor(
    private val apiService: CharacterDetailApiService,
) : BaseRepository() {
    fun fetchCharacterById(id: Int) = doRequest {
        apiService.fetchCharacterById(id)
    }
}