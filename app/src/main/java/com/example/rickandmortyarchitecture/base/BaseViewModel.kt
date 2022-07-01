package com.example.rickandmortyarchitecture.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bacon.common.either.Either
import com.example.rickandmortyarchitecture.presentation.state.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    @Suppress("FunctionName")
    protected fun <T> MutableUIStateFlow() = MutableStateFlow<UIState<T>>(UIState.Idle())

    /**
     * Collect network request
     *
     * @return [UIState] depending request result
     */
    protected fun <T> Flow<Either<String, T>>.collectRequest(
        state: MutableStateFlow<UIState<T>>,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            state.value = UIState.Loading()
            this@collectRequest.collect {
                when (it) {
                    is Either.Left -> state.value = UIState.Error(it.value)
                    is Either.Right -> state.value = UIState.Success(it.value)
                }
            }
        }
    }

    /**
     * Collect network request with mapping from domain to ui
     *
     * @return [UIState] depending request result
     */
    protected fun <T, S> Flow<Either<String, T>>.collectRequest(
        state: MutableStateFlow<UIState<S>>,
        mappedData: (T) -> S,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            state.value = UIState.Loading()
            this@collectRequest.collect {
                when (it) {
                    is Either.Left -> state.value = UIState.Error(it.value)
                    is Either.Right -> state.value = UIState.Success(mappedData(it.value))
                }
            }
        }
    }

}