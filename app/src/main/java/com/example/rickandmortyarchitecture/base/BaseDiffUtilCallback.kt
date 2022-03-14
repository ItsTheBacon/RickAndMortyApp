package com.example.rickandmortyarchitecture.base

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.bacon.common.IBaseDiffModel

class BaseDiffUtilCallback<T : IBaseDiffModel> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(
        oldItem: T,
        newItem: T,
    ) = oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: T,
        newItem: T,
    ) = oldItem.id == newItem.id
}
