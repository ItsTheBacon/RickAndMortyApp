package com.example.rickandmortyarchitecture.extensions

import android.net.Uri

 fun String.getIdFromUrl() = Uri.parse(this).lastPathSegment?.toInt()!!
