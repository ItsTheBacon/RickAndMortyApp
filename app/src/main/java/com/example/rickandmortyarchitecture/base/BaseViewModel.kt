package com.example.rickandmortyarchitecture.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bacon.common.resouce.Resource
import com.example.rickandmortyarchitecture.presentation.state.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> subscribeTo(
        state: MutableLiveData<UIState<T>>,
        request: () -> Flow<Resource<T>>,
    ) {
        viewModelScope.launch {
            request().collect {
                when (it) {
                    is Resource.Error -> {
                        it.message?.let { error ->
                            state.value = UIState.Error(error)
                        }
                    }
                    is Resource.Loading -> {
                        state.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        it.data?.let { data ->
                            state.value = UIState.Success(data)
                        }
                    }
                }
            }
        }
    }

    protected fun <T, S> Flow<Resource<T>>.collectRequest(
        state: MutableStateFlow<UIState<S>>,
        mappedData: (T) -> S
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            this@collectRequest.collect {
                when (it) {
                    is Resource.Loading -> {
                        state.value = UIState.Loading()
                    }
                    is Resource.Error -> it.message?.let { error ->
                        state.value = UIState.Error(error)
                    }
                    is Resource.Success -> it.data?.let { data ->
                        state.value = UIState.Success(mappedData(data))
                    }
                }
            }
        }
    }
}