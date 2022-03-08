package com.example.rickandmortyarchitecture.extensions

import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections



fun NavController.navigateSafely(@IdRes actionId: Int) {
    currentDestination?.getAction(actionId)?.let { navigate(actionId) }
}

fun NavController.navigateSafely(directions: NavDirections) {
    currentDestination?.getAction(directions.actionId)?.let { navigate(directions) }
}
