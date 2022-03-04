package com.bacon.domain.models

data class RickAndMortyResponse<T>(
    var info: Info,
    var results: ArrayList<T>,
)