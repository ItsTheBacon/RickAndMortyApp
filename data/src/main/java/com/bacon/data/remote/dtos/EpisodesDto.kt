package com.bacon.data.remote.dtos

import com.bacon.common.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class EpisodesDto(

    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("air_date")
    var air_date: String? = null,
    @SerializedName("episode")
    var episode: String? = null,
    @SerializedName("created")
    var created: String? = null,
): IBaseDiffModel

