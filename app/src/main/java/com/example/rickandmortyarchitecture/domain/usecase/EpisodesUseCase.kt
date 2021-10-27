package com.example.rickandmortyarchitecture.domain.usecase

import com.example.rickandmortyarchitecture.domain.repository.EpisodesRepository
import javax.inject.Inject

class EpisodesUseCase @Inject constructor(private val repository: EpisodesRepository) {
    operator fun invoke(page: Int) = repository.fetchEpisodes(page)
}