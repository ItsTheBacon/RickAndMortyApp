package com.bacon.data.remote.dtos

import com.bacon.common.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("dimension")
    var dimension: String? = null,
    @SerializedName("created")
    var created: String? = null,

    ):IBaseDiffModel

