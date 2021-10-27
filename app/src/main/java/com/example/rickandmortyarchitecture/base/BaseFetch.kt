package com.example.rickandmortyarchitecture.base

interface BaseFetch {
    var page: Int
    fun fetchRick(page: Int)
}