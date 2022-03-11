package com.bacon.domain.usecase

import com.bacon.domain.repository.CharacterRepository
import javax.inject.Inject

class FetchCharactersUseCase @Inject constructor(private val repository: CharacterRepository) {
    operator fun invoke(page: Int) = repository.fetchCharacters(page)
}