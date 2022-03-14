package com.bacon.data.remote.repository

import com.bacon.data.remote.apiservices.EpisodesApiService
import com.bacon.data.remote.repository.base.BaseRepository
import javax.inject.Inject

class EpisodeDetailRepository @Inject constructor(
    private val service: EpisodesApiService,
) : BaseRepository() {
    fun fetchEpisode(id: Int) = doRequest {
        service.fetchEpisode(id)
    }
}