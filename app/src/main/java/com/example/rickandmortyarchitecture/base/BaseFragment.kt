package com.example.rickandmortyarchitecture.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<V : BaseViewModel, B : ViewBinding>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    protected abstract val binding: B
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

}