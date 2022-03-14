package com.bacon.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class InfoDto(
    @SerializedName("count")
    var count: Int? = null,
    @SerializedName("pages")
    var pages: Int? = null,
    @SerializedName("next")
    var next: String? = null,
    @SerializedName("prev")
    var prev: String? = null,
)

