package com.bacon.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponseDto<T>(
    @SerializedName("info")
    var info: InfoDto,

    @SerializedName("results")
    var results: ArrayList<T>,

    )

