package com.example.rickandmortyarchitecture.domain.repository

import com.example.rickandmortyarchitecture.common.resouce.Resource
import com.example.rickandmortyarchitecture.domain.models.EpisodesModel
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {
    fun fetchEpisodes(): Flow<Resource<List<EpisodesModel>>>

}