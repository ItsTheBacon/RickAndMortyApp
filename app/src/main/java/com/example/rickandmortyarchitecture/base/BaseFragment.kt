package com.example.rickandmortyarchitecture.base

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingData
import androidx.viewbinding.ViewBinding
import com.example.rickandmortyarchitecture.presentation.state.UIState
import com.google.android.material.progressindicator.CircularProgressIndicator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


abstract class BaseFragment<V : BaseViewModel, BaseViewBinding : ViewBinding>(
    @LayoutRes layoutId: Int,
) : Fragment(layoutId) {

    protected abstract val binding: BaseViewBinding
    protected abstract val viewModel: V

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        setupArgs()
        setupRequests()
        setupObserve()
        setupViews()
    }

    open fun setupArgs() {
    }

    open fun setupObserve() {
    }

    open fun setupRequests() {
    }

    open fun setupListener() {
    }

    open fun initialize() {
    }

    open fun setupViews() {
    }

    protected fun <T> StateFlow<UIState<T>>.collectUIState(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        action: (UIState<T>) -> Unit,
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(lifecycleState) {
                this@collectUIState.collect {
                    action(it)
                }
            }
        }
    }

    private fun collectFlowSafely(
        lifecycleState: Lifecycle.State,
        collect: suspend () -> Unit,
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(lifecycleState) {
                collect()
            }
        }
    }


    protected fun <T> StateFlow<UIState<T>>.collectUIStateWithParameters(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        state: ((UIState<T>) -> Unit)? = null,
        onLoading: ((UIState<T>) -> Unit)? = null,
        onError: ((error: String) -> Unit),
        onSuccess: ((data: T) -> Unit),
    ) {
        collectFlowSafely(lifecycleState) {
            this.collect {
                state?.invoke(it)
                when (it) {
                    is UIState.Idle -> {}
                    is UIState.Loading -> {
                        onLoading?.invoke(it)
                    }
                    is UIState.Error -> onError.invoke(it.error)
                    is UIState.Success -> onSuccess.invoke(it.data)
                }
            }
        }
    }


    protected fun <T : Any> Flow<PagingData<T>>.collectPaging(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        action: suspend (value: PagingData<T>) -> Unit,
    ) {
        collectFlowSafely(lifecycleState) { this.collectLatest { action(it) } }
    }


    protected fun <T> UIState<T>.setupViewVisibility(
        group: ViewGroup, loader: CircularProgressIndicator, isNavigateWhenSuccess: Boolean = false,
    ) {
        fun showLoader(isVisible: Boolean) {
            group.isVisible = !isVisible
            loader.isVisible = isVisible
        }

        when (this) {
            is UIState.Idle -> {}
            is UIState.Loading -> showLoader(true)
            is UIState.Error -> showLoader(false)
            is UIState.Success -> if (!isNavigateWhenSuccess) showLoader(false)
        }
    }
}