package com.bacon.domain.usecase

import com.bacon.domain.repository.EpisodesDetailRepository
import javax.inject.Inject

class FetchEpisodesDetailUseCase @Inject constructor(private val repository: EpisodesDetailRepository) {
    operator fun invoke(id: Int) = repository.fetchEpisode(id)

}