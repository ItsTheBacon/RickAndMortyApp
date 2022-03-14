package com.bacon.data.remote.repository.base

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bacon.common.resouce.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = request()))
        } catch (ioException: Exception) {
            emit(
                Resource.Error(
                    data = null,
                    message = ioException.localizedMessage ?: "Error Occurred!"
                )
            )
        }
    }

    protected fun <ValueDto : Any> doRequestWithPaging(
        pagingSource: BasePagingSource<ValueDto>,
        pageSize: Int = 25,
        prefetchDistance: Int = pageSize,
        enabledPlaceholder: Boolean = true,
        initialLoadSize: Int = pageSize * 3,
        maxSize: Int = Int.MAX_VALUE,
        jumpThreshold: Int = Int.MIN_VALUE,
    ): Flow<PagingData<ValueDto>> {
        return Pager(
            config = PagingConfig(
                pageSize,
                prefetchDistance,
                enabledPlaceholder,
                initialLoadSize,
                maxSize,
                jumpThreshold
            ),
            pagingSourceFactory = { pagingSource }
        ).flow
    }

}