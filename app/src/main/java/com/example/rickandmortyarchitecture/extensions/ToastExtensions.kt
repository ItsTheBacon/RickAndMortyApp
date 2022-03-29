package com.example.rickandmortyarchitecture.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToastShort(text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}