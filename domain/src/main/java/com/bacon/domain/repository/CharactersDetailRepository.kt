package com.bacon.domain.repository

import com.bacon.common.resouce.Resource
import com.bacon.domain.models.CharactersModel
import kotlinx.coroutines.flow.Flow

interface CharactersDetailRepository {
     fun fetchCharacterById(id: Int): Flow<Resource<CharactersModel>>
}