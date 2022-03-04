package com.bacon.domain.usecase

import com.bacon.domain.repository.EpisodesRepository
import javax.inject.Inject

class EpisodesUseCase @Inject constructor(private val repository: EpisodesRepository) {
    operator fun invoke(page: Int) = repository.fetchEpisodes(page)
}