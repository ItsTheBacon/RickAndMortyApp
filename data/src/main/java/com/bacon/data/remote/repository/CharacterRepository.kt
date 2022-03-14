package com.bacon.data.remote.repository

import com.bacon.data.remote.apiservices.CharacterApiService
import com.bacon.data.remote.pagingsource.CharactersPagingSource
import com.bacon.data.remote.repository.base.BaseRepository
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val service: CharacterApiService,
) : BaseRepository() {
    fun fetchCharacters() =
        doRequestWithPaging(CharactersPagingSource(service))
}