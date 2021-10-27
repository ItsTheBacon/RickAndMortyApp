package com.example.rickandmortyarchitecture.domain.repository

import com.example.rickandmortyarchitecture.common.resouce.Resource
import com.example.rickandmortyarchitecture.domain.models.CharactersModel
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun fetchCharacters(page: Int): Flow<Resource<List<CharactersModel>>>
}