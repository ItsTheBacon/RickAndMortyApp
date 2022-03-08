package com.example.rickandmortyarchitecture.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyarchitecture.base.BaseDiffUtilCallback
import com.example.rickandmortyarchitecture.databinding.EpisodesListBinding
import com.example.rickandmortyarchitecture.presentation.models.CharactersUI


class EpisodesListAdapter(
) : ListAdapter<String, EpisodesListAdapter.EpisodeViewHolder>(
    BaseDiffUtilCallback()
) {


    class EpisodeViewHolder(private val binding: EpisodesListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: String) {
            binding.episodeViewList.text = item ?: "None"
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(EpisodesListBinding.inflate(LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        ))
    }

    override fun onBindViewHolder(viewHolder: EpisodeViewHolder, position: Int) {
        viewHolder.onBind(getItem(position))
    }


}