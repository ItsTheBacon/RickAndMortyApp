package com.example.rickandmortyarchitecture.extensions


typealias Mapper<T, R> = (T) -> R

fun <T, R> Mapper<T, R>.fromToList(input: List<T>?) =
    input?.map {
        invoke(it)
    }
