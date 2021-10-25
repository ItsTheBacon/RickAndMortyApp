package com.example.rickandmortyarchitecture.domain.models

data class CharactersModel(
    var id: Int? = null,
    var name: String? = null,
    var status: String? = null,
    var image: String? = null,
    var species: String? = null,
    var gender: String? = null
)