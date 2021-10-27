package com.example.rickandmortyarchitecture.data.repository

import com.example.rickandmortyarchitecture.base.BaseRepository
import com.example.rickandmortyarchitecture.data.network.apiservices.EpisodesApiService
import com.example.rickandmortyarchitecture.data.network.dtos.toEpisodes
import com.example.rickandmortyarchitecture.data.network.dtos.toResponse
import com.example.rickandmortyarchitecture.domain.repository.EpisodesRepository
import javax.inject.Inject

class EpisodesRepositoryImpl @Inject constructor(private val service: EpisodesApiService) :
    BaseRepository(), EpisodesRepository {
    override fun fetchEpisodes(page: Int) = doRequest {
        service.fetchEpisodes(page).toResponse().results.map {
            it.toEpisodes()
        }
    }
}