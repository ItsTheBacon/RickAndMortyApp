package com.bacon.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class OriginDto(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String,
)