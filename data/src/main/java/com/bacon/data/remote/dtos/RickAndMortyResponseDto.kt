package com.bacon.data.remote.dtos

import com.bacon.domain.models.RickAndMortyResponse
import com.google.gson.annotations.SerializedName

data class RickAndMortyResponseDto<T>(
    @SerializedName("info")
    var info: InfoDto,

    @SerializedName("results")
    var results: ArrayList<T>,

    )

fun <T> RickAndMortyResponseDto<T>.toResponse() = RickAndMortyResponse(
    info.toInfo(), results
)