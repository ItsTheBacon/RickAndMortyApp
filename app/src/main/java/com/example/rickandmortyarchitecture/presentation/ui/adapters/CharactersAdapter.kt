package com.example.rickandmortyarchitecture.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.base.BaseDiffUtilCallback
import com.example.rickandmortyarchitecture.databinding.ItemCharactersRickBinding
import com.example.rickandmortyarchitecture.extensions.capitalized
import com.example.rickandmortyarchitecture.extensions.load
import com.example.rickandmortyarchitecture.presentation.models.CharactersUI

class CharactersAdapter(
    val onItemLongClick: (photo: String) -> Unit,
    val onItemClickListener: (id: Int) -> Unit,
) : ListAdapter<CharactersUI, CharactersAdapter.ViewHolder>(
    BaseDiffUtilCallback()
) {
    inner class ViewHolder(
        private val binding: ItemCharactersRickBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let {
                    onItemClickListener(it.id)
                }
            }
        }

        @SuppressLint("SetTextI18n")
        fun onBind(data: CharactersUI) = with(binding) {
            imageItemCharacter.load(data.image)
            nameCharacter.text = data.name
            when (data.status) {
                "Alive" -> icStatusCharacter.setImageResource(R.drawable.character_status_alive)
                "Dead" -> icStatusCharacter.setImageResource(R.drawable.character_status_dead)
                "unknown" -> icStatusCharacter.setImageResource(R.drawable.character_status_unknown)
            }
            speciesCharacter.text = "${data.status.capitalized()} - ${data.species}"

            lastKnowLocation.text = data.location.name.capitalized()
            imageItemCharacter.setOnLongClickListener {
                getItem(absoluteAdapterPosition)?.apply { onItemLongClick(image!!) }
                false
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharactersRickBinding.inflate
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