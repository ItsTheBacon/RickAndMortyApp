package com.example.rickandmortyarchitecture.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bacon.data.remote.dtos.CharactersDto
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.base.BaseDiffUtilCallback
import com.example.rickandmortyarchitecture.databinding.ItemCharactersRickBinding
import com.example.rickandmortyarchitecture.extensions.load

class CharactersAdapter(
    val onItemLongClick: (photo: String) -> Unit,
    val onItemClickListener: (id: Int, name: String) -> Unit,
    val fetchFirstSeenIn: (position: Int, episodeUrl: String) -> Unit,
) : PagingDataAdapter<CharactersDto, CharactersAdapter.ViewHolder>(
    BaseDiffUtilCallback()
) {
    inner class ViewHolder(
        private val binding: ItemCharactersRickBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let {
                    onItemClickListener(it.id, it.name)
                }
            }
        }

        @SuppressLint("SetTextI18n")
        fun onBind(character: CharactersDto) = with(binding) {
            imageItemCharacter.load(character.image)
            textItemCharacterName.text = character.name
            when (character.status) {
                "Alive" -> imageItemCharacterStatus.setImageResource(R.drawable.character_status_alive)
                "Dead" -> imageItemCharacterStatus.setImageResource(R.drawable.character_status_dead)
                "unknown" -> imageItemCharacterStatus.setImageResource(R.drawable.character_status_unknown)
            }
            textItemCharacterStatusAndSpecies.text = textItemCharacterStatusAndSpecies
                .context
                .resources
                .getString(
                    R.string.hyphen, character.status, character.species
                )
            with(textItemCharacterLastKnownLocationData) {
                text = character.location.name
                isEnabled = character.location.url.isNotEmpty()
            }
            imageItemCharacter.setOnLongClickListener {
                getItem(absoluteAdapterPosition)?.apply { onItemLongClick(image) }
                false
            }
            setupFirstSeenIn(character.firstSeenIn, character.episode.first())

        }

        private fun setupFirstSeenIn(firstSeenIn: String? = null, episode: String) = with(binding) {
            progressBarCharacterFirstSeenIn.isVisible = firstSeenIn == null
            textItemCharacterFirstSeenInData.isVisible = firstSeenIn != null
            if (firstSeenIn == null) {
                fetchFirstSeenIn(absoluteAdapterPosition, episode)
            } else {
                textItemCharacterFirstSeenInData.text = firstSeenIn
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    fun setFirstSeenIn(position: Int, firstSeenIn: String) {
        getItem(position)?.firstSeenIn = firstSeenIn
        notifyItemChanged(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharactersRickBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,

                false
            )
        )
    }

}