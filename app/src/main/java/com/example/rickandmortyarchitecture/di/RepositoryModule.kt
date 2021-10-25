package com.example.rickandmortyarchitecture.di

import com.example.rickandmortyarchitecture.data.network.apiservices.CharacterApiService
import com.example.rickandmortyarchitecture.data.network.apiservices.EpisodesApiService
import com.example.rickandmortyarchitecture.data.network.apiservices.LocationApiService
import com.example.rickandmortyarchitecture.data.repository.CharacterRepositoryImpl
import com.example.rickandmortyarchitecture.data.repository.EpisodesRepositoryImpl
import com.example.rickandmortyarchitecture.data.repository.LocationRepositoryImpl
import com.example.rickandmortyarchitecture.domain.repository.CharacterRepository
import com.example.rickandmortyarchitecture.domain.repository.EpisodesRepository
import com.example.rickandmortyarchitecture.domain.repository.LocationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    fun provideEverythingRepository(characterApiService: CharacterApiService): CharacterRepository {
        return CharacterRepositoryImpl(characterApiService)
    }

    @Provides
    fun provideLocationRepository(locationApiService: LocationApiService): LocationRepository {
        return LocationRepositoryImpl(locationApiService)
    }

    @Provides
    fun provideEpisodesRepository(episodesApiService: EpisodesApiService): EpisodesRepository {
        return EpisodesRepositoryImpl(episodesApiService)
    }
}