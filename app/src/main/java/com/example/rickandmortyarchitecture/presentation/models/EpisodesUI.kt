package com.example.rickandmortyarchitecture.presentation.models

import com.bacon.domain.models.EpisodesModel

data class EpisodesUI(

    var id: Int? = null,
    var name: String? = null,
    var air_date: String? = null,
    var episode: String? = null,
    var created: String? = null,
)

fun EpisodesModel.toUI() = EpisodesUI(
    id, name, air_date, episode, created
)