package com.example.rickandmortyarchitecture.di

import com.example.rickandmortyarchitecture.data.network.RetrofitClient
import com.example.rickandmortyarchitecture.data.network.apiservices.CharacterApiService
import com.example.rickandmortyarchitecture.data.network.apiservices.EpisodesApiService
import com.example.rickandmortyarchitecture.data.network.apiservices.LocationApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    val retrofit: RetrofitClient = RetrofitClient()


    @Singleton
    @Provides
    fun fetchCharacterApiService(): CharacterApiService {
        return retrofit.provideCharacterApiService()
    }

    @Singleton
    @Provides
    fun fetchLocationApiService(): LocationApiService {
        return retrofit.provideLocationApiService()
    }

    @Singleton
    @Provides
    fun provideEpisodesApiService(): EpisodesApiService {
        return retrofit.provideEpisodesApiService()
    }
}

