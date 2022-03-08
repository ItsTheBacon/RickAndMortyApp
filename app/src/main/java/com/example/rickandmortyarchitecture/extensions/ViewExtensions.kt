package com.example.rickandmortyarchitecture.extensions

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import java.util.*

fun View.isVisible(isVisible: Boolean) {
    this.isVisible = isVisible
}

fun View.isVisibleOrGone(isVisible: Boolean) {
    if (isVisible) {
        this.visibility = VISIBLE
    } else {
        this.visibility = GONE
    }
}

fun ImageView.load(uri:String){
    Glide.with(this)
        .load(uri)
        .into(this)
}

fun String.capitalized(): String {
    return this.replaceFirstChar {
        if (it.isLowerCase())
            it.titlecase(Locale.getDefault())
        else it.toString()
    }
}

