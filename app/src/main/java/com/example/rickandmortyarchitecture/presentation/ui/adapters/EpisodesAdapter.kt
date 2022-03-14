package com.example.rickandmortyarchitecture.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bacon.data.remote.dtos.EpisodesDto
import com.example.rickandmortyarchitecture.base.BaseDiffUtilCallback
import com.example.rickandmortyarchitecture.databinding.ItemEpisodesRickBinding

class EpisodesAdapter : PagingDataAdapter<EpisodesDto, EpisodesAdapter.ViewHolder>(
    BaseDiffUtilCallback()
) {
    inner class ViewHolder(
        private val binding: ItemEpisodesRickBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(episode: EpisodesDto) {
            with(binding) {
                textItemEpisodeName.text = episode.name
                textItemEpisodeAirDate.text = episode.air_date
                textItemEpisodeCodeOfEpisode.text = episode.episode
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEpisodesRickBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        )
    }

}