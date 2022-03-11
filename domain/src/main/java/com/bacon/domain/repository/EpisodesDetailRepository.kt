package com.bacon.domain.repository

import com.bacon.common.resouce.Resource
import com.bacon.domain.models.EpisodesModel
import kotlinx.coroutines.flow.Flow

interface EpisodesDetailRepository {
    fun fetchEpisode(id: Int): Flow<Resource<EpisodesModel>>
}