package com.example.rickandmortyarchitecture.extensions

import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyarchitecture.base.BaseFetch


fun RecyclerView.scrollWithPagination(viewModel: BaseFetch) {
    this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                viewModel.page++
                viewModel.fetchRick(viewModel.page)
            }
        }
    })
}
