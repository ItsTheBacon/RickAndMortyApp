package com.example.rickandmortyarchitecture.presentation.models

import com.bacon.domain.models.EpisodesModel
import com.example.rickandmortyarchitecture.base.IBaseDiffModel

data class EpisodesUI(
    override val id: Int,
    var name: String? = null,
    var air_date: String? = null,
    var episode: String? = null,
    var created: String? = null,
) : IBaseDiffModel

fun EpisodesModel.toUI() = EpisodesUI(
    id, name, air_date, episode, created
)