package com.bacon.domain.repository

import com.bacon.common.either.Either
import com.bacon.domain.models.EpisodesModel
import kotlinx.coroutines.flow.Flow

interface EpisodesDetailRepository {
    fun fetchEpisode(id: Int): Flow<Either<String, EpisodesModel>>
}