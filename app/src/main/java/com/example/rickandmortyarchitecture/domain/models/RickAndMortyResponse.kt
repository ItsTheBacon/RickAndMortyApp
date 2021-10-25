package com.example.rickandmortyarchitecture.domain.models

data class RickAndMortyResponse<T>(
    var info: Info,
    var results: ArrayList<T>
)