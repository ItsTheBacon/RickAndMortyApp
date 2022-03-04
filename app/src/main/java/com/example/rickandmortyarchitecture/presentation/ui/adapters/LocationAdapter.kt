package com.example.rickandmortyarchitecture.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bacon.domain.models.LocationsModel
import com.example.rickandmortyarchitecture.base.BaseDiffUtilCallback
import com.example.rickandmortyarchitecture.databinding.ItemLocationRickBinding

class LocationAdapter : ListAdapter<LocationsModel, LocationAdapter.ViewHolder>(
    BaseDiffUtilCallback()
) {
    inner class ViewHolder(
        private val binding: ItemLocationRickBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: LocationsModel) {
            with(binding) {
                name.text = data.name
                description.text = data.created

            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLocationRickBinding.inflate
                (
                LayoutInflater.from(
                    parent.context
                ),
                parent,

                false
            )
        )
    }

}