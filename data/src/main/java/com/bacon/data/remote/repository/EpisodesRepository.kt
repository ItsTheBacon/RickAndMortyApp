package com.bacon.data.remote.repository

import com.bacon.data.remote.apiservices.EpisodesApiService
import com.bacon.data.remote.pagingsource.EpisodesPagingSource
import com.bacon.data.remote.repository.base.BaseRepository
import javax.inject.Inject

class EpisodesRepository @Inject constructor(
    private val service: EpisodesApiService,
) : BaseRepository() {
    fun fetchEpisodes() =
        doRequestWithPaging(EpisodesPagingSource(service))
}