package com.example.rickandmortyarchitecture.data.network.dtos

import com.example.rickandmortyarchitecture.domain.models.LocationsModel
import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("dimension")
    var dimension: String? = null,
    @SerializedName("created")
    var created: String? = null

)

fun LocationDto.toLocation(): LocationsModel {
    return LocationsModel(id, name, type, dimension, created)
}