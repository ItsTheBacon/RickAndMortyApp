package com.example.rickandmortyarchitecture.presentation.models

import com.bacon.domain.models.LocationsModel

data class LocationsUI(
    var id: Int? = null,
    var name: String? = null,
    var type: String? = null,
    var dimension: String? = null,
    var created: String? = null,
)

fun LocationsModel.toUI() = LocationsUI(
    id, name, type, dimension, created
)
