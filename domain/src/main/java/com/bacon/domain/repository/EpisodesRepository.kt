package com.bacon.domain.repository

import com.bacon.common.either.Either
import com.bacon.common.resouce.Resource
import com.bacon.domain.models.EpisodesModel
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {
    fun fetchEpisodes(page: Int): Flow<Either<String,List<EpisodesModel>>>

}