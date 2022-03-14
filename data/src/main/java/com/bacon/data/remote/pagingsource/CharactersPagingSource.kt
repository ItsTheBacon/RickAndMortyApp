package com.bacon.data.remote.pagingsource

import com.bacon.data.remote.apiservices.CharacterApiService
import com.bacon.data.remote.dtos.CharactersDto
import com.bacon.data.remote.repository.base.BasePagingSource

class CharactersPagingSource(
    private val service: CharacterApiService,
) : BasePagingSource<CharactersDto>({
    service.fetchCharacters(it)
})
