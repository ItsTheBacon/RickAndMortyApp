package com.example.rickandmortyarchitecture.data.network.dtos

import com.example.rickandmortyarchitecture.domain.models.Info
import com.google.gson.annotations.SerializedName

data class InfoDto(
    @SerializedName("count")
    var count: Int? = null,
    @SerializedName("pages")
    var pages: Int? = null,
    @SerializedName("next")
    var next: String? = null,
    @SerializedName("prev")
    var prev: String? = null
)

fun InfoDto.toInfo(): Info {
    return Info(count, pages, next, prev)
}
