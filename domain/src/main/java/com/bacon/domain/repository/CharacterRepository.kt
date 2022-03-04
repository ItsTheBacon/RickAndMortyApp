package com.bacon.domain.repository

import com.bacon.common.resouce.Resource
import com.bacon.domain.models.CharactersModel
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun fetchCharacters(page: Int): Flow<Resource<List<CharactersModel>>>
}