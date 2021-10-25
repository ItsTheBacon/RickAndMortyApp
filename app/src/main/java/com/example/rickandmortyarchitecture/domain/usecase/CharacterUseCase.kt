package com.example.rickandmortyarchitecture.domain.usecase

import com.example.rickandmortyarchitecture.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterUseCase @Inject constructor(private val repository: CharacterRepository) {
    operator fun invoke() = repository.fetchCharacters()
}