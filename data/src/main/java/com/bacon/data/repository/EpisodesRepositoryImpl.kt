package com.bacon.data.repository

import com.bacon.data.remote.apiservices.EpisodesApiService
import com.bacon.data.remote.dtos.toEpisodes
import com.bacon.data.remote.dtos.toResponse
import com.bacon.data.repository.base.BaseRepository
import com.bacon.domain.repository.EpisodesRepository
import javax.inject.Inject

class EpisodesRepositoryImpl @Inject constructor(private val service: EpisodesApiService) :
    BaseRepository(), EpisodesRepository {
    override fun fetchEpisodes(page: Int) = doRequest {
        service.fetchEpisodes(page).toResponse().results.map {
            it.toEpisodes()
        }
    }
}