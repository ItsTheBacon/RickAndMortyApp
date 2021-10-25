package com.example.rickandmortyarchitecture.base

import com.example.rickandmortyarchitecture.common.resouce.Resource
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
}