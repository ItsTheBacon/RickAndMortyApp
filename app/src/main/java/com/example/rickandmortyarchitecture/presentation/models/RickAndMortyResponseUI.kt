package com.example.rickandmortyarchitecture.presentation.models

import com.bacon.domain.models.RickAndMortyResponse

data class RickAndMortyResponseUI<T>(
    var info: InfoUI,
    var results: ArrayList<T>,
)

fun <T> RickAndMortyResponse<T>.toUI() = RickAndMortyResponseUI<T>(
    info.toUI(),
    results
)