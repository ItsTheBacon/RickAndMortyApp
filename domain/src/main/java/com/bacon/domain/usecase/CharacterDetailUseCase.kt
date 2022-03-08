package com.bacon.domain.usecase

import com.bacon.domain.repository.CharactersDetailRepository
import javax.inject.Inject

class CharacterDetailUseCase @Inject constructor(private val repository: CharactersDetailRepository) {
    operator fun invoke(id: Int) = repository.fetchCharacterById(id)
}