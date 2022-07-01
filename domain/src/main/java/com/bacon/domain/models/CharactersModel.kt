package com.bacon.domain.models

data class CharactersModel(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginModel,
    val location: CharacterLocationModel,
    val image: String,
    val episode: ArrayList<String>,
    val url: String,
    val created: String,
)

data class CharacterLocationModel(
    val name: String,
    val url: String,
)