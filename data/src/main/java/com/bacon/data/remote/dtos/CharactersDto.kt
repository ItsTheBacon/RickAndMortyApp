package com.bacon.data.remote.dtos

import com.bacon.domain.models.CharacterLocationModel
import com.bacon.domain.models.CharactersModel
import com.bacon.domain.models.OriginModel
import com.google.gson.annotations.SerializedName

data class CharactersDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("species")
    val species: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("origin")
    val origin: OriginDto,

    @SerializedName("location")
    val location: CharacterLocationDto,

    @SerializedName("image")
    val image: String,

    @SerializedName("episode")
    val episode: ArrayList<String>,

    @SerializedName("url")
    val url: String,

    @SerializedName("created")
    val created: String,
)

data class CharacterLocationDto(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String,
)

fun OriginDto.toOrigin() = OriginModel(
    name, url
)

fun CharacterLocationDto.toDomain() = CharacterLocationModel(
    name, url
)

fun CharactersDto.toCharacter() = CharactersModel(
    id,
    name,
    status,
    species,
    type,
    gender,
    origin.toOrigin(),
    location.toDomain(),
    image,
    episode,
    url,
    created

)

