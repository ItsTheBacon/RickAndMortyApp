package com.bacon.data.repository

import com.bacon.data.remote.apiservices.EpisodesApiService
import com.bacon.data.remote.dtos.toEpisodes
import com.bacon.data.repository.base.BaseRepository
import com.bacon.domain.repository.EpisodesDetailRepository
import javax.inject.Inject

class EpisodeDetailRepositoryImpl @Inject constructor(
    private val service: EpisodesApiService,
) : BaseRepository(), EpisodesDetailRepository {
    override fun fetchEpisode(id: Int) = doRequest {
        service.fetchEpisode(id).toEpisodes()
    }
}