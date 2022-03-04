package com.example.rickandmortyarchitecture.presentation.ui.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.rickandmortyarchitecture.base.BaseDiffUtilCallback
import com.example.rickandmortyarchitecture.databinding.ItemCharactersRickBinding
import com.example.rickandmortyarchitecture.domain.models.CharactersModel

class CharactersAdapter(
    val onItemLongClick: (photo: String) -> Unit
) : ListAdapter<CharactersModel, CharactersAdapter.ViewHolder>(
    BaseDiffUtilCallback()
) {
    inner class ViewHolder(
        private val binding: ItemCharactersRickBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: CharactersModel) {
            with(binding) {
                Glide.with(imgCharacter)
                    .load(data.image)
                    .listener(object : RequestListener<Drawable?> {

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable?>?,
                            dataSource: com.bumptech.glide.load.DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                            itemProgressBar.visibility = View.GONE
                            return false
                        }

                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable?>?,
                            isFirstResource: Boolean
                        ): Boolean {
                            itemProgressBar.visibility = View.GONE
                            return false
                        }
                    })
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(imgCharacter)
                txtName.text = data.name
                genres.text = data.status
                imgCharacter.setOnLongClickListener {
                    getItem(adapterPosition)?.apply { onItemLongClick(image!!) }
                    false
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
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