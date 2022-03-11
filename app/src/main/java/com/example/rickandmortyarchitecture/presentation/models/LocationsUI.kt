package com.example.rickandmortyarchitecture.presentation.models

import com.bacon.domain.models.LocationsModel
import com.example.rickandmortyarchitecture.base.IBaseDiffModel

data class LocationsUI(
    override val id: Int,
    var name: String? = null,
    var type: String? = null,
    var dimension: String? = null,
    var created: String? = null,
) : IBaseDiffModel

fun LocationsModel.toUI() = LocationsUI(
    id, name, type, dimension, created
)
