package com.bacon.data.remote.pagingsource

import com.bacon.data.remote.apiservices.EpisodesApiService
import com.bacon.data.remote.dtos.EpisodesDto
import com.bacon.data.remote.repository.base.BasePagingSource

class EpisodesPagingSource(
    private val service: EpisodesApiService
) :BasePagingSource<EpisodesDto>({
    service.fetchEpisodes(it)
})