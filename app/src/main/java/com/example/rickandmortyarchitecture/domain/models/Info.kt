package com.example.rickandmortyarchitecture.domain.models

data class Info(
    var count: Int? = null,
    var pages: Int? = null,
    var next: String? = null,
    var prev: String? = null
)