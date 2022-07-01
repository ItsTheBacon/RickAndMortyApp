package com.example.rickandmortyarchitecture.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyarchitecture.base.BaseDiffUtilCallback
import com.example.rickandmortyarchitecture.databinding.ItemLocationRickBinding
import com.example.rickandmortyarchitecture.presentation.models.LocationsUI

class LocationAdapter : ListAdapter<LocationsUI, LocationAdapter.ViewHolder>(
    BaseDiffUtilCallback()
) {
    inner class ViewHolder(
        private val binding: ItemLocationRickBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: LocationsUI) {
            with(binding) {
                name.text = data.name
                description.text = data.created
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