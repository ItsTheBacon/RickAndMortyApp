package com.example.rickandmortyarchitecture.di

import com.bacon.data.remote.RetrofitClient
import com.bacon.data.remote.apiservices.CharacterApiService
import com.bacon.data.remote.apiservices.CharacterDetailApiService
import com.bacon.data.remote.apiservices.EpisodesApiService
import com.bacon.data.remote.apiservices.LocationApiService
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

    @Singleton
    @Provides
    fun provideCharacterDetailApiService(): CharacterDetailApiService {
        return retrofit.provideCharacterDetailApiService()
    }
}

