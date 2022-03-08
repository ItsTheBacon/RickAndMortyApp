package com.example.rickandmortyarchitecture.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.example.rickandmortyarchitecture.presentation.state.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


abstract class BaseFragment<V : BaseViewModel, BaseViewBinding : ViewBinding>(
    @LayoutRes layoutId: Int,
) : Fragment(layoutId) {

    protected abstract val binding: BaseViewBinding
    protected abstract val viewModel: V
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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
}