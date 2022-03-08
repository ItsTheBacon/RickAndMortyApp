package com.example.rickandmortyarchitecture.presentation.models

import com.bacon.domain.models.Info

data class InfoUI(
    var count: Int? = null,
    var pages: Int? = null,
    var next: String? = null,
    var prev: String? = null,
)

fun Info.toUI() = InfoUI(
    count, pages, next, prev
)