package com.bacon.data.remote.dtos

import com.bacon.domain.models.EpisodesModel
import com.google.gson.annotations.SerializedName

data class EpisodesDto(

    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("air_date")
    var air_date: String? = null,
    @SerializedName("episode")
    var episode: String? = null,
    @SerializedName("created")
    var created: String? = null,
)

fun EpisodesDto.toEpisodes(): EpisodesModel {
    return EpisodesModel(id, name, air_date, episode, created)
}
