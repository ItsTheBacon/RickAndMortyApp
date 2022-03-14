package com.example.rickandmortyarchitecture.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bacon.data.remote.dtos.LocationDto
import com.example.rickandmortyarchitecture.base.BaseDiffUtilCallback
import com.example.rickandmortyarchitecture.databinding.ItemLocationRickBinding

class LocationAdapter : PagingDataAdapter<LocationDto, LocationAdapter.ViewHolder>(
    BaseDiffUtilCallback()
) {
    inner class ViewHolder(
        private val binding: ItemLocationRickBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: LocationDto) {
            with(binding) {
                textItemLocationName.text = data.name
                textItemLocationType.text = data.type
                textItemLocationDimension.text = data.dimension
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLocationRickBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

}