package com.bacon.data.remote.dtos

import com.bacon.common.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class CharactersDto(
    @SerializedName("id")
    override val id: Int,

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

    var firstSeenIn: String = ""
) : IBaseDiffModel

data class CharacterLocationDto(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String,
)

