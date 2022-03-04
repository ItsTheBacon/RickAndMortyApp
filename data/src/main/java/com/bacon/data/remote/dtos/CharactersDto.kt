package com.bacon.data.remote.dtos

import com.bacon.domain.models.CharactersModel
import com.google.gson.annotations.SerializedName

data class CharactersDto(
    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("species")
    var species: String? = null,

    @SerializedName("gender")
    var gender: String? = null,
)

fun CharactersDto.toCharacter(): CharactersModel {
    return CharactersModel(
        id,
        name,
        status,
        image,
        species,
        gender
    )
}
