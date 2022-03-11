package com.example.rickandmortyarchitecture.presentation.models

import com.bacon.domain.models.CharacterLocationModel
import com.bacon.domain.models.CharactersModel
import com.bacon.domain.models.OriginModel
import com.example.rickandmortyarchitecture.base.IBaseDiffModel

data class CharactersUI(
    override val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginUI,
    val location: CharacterLocationUI,
    val image: String,
    val episode: ArrayList<String>,
    val url: String,
    val created: String,
    var firstSeenIn: String = "",
) : IBaseDiffModel

data class OriginUI(
    val name: String,
    val url: String,
)

data class CharacterLocationUI(
    val name: String,
    val url: String,
)

fun OriginModel.toUI() = OriginUI(
    name, url
)

fun CharacterLocationModel.toUI() = CharacterLocationUI(
    name, url
)

fun CharactersModel.toUI() = CharactersUI(
    id,
    name,
    status,
    species,
    type,
    gender,
    origin.toUI(),
    location.toUI(),
    image,
    episode,
    url,
    created

)