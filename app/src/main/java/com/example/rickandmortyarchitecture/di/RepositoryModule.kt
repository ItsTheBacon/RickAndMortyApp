package com.example.rickandmortyarchitecture.di

import com.bacon.data.remote.apiservices.CharacterApiService
import com.bacon.data.remote.apiservices.CharacterDetailApiService
import com.bacon.data.remote.apiservices.EpisodesApiService
import com.bacon.data.remote.apiservices.LocationApiService
import com.bacon.data.repository.CharacterRepositoryImpl
import com.bacon.data.repository.CharactersDetailRepositoryImpl
import com.bacon.data.repository.EpisodesRepositoryImpl
import com.bacon.data.repository.LocationRepositoryImpl
import com.bacon.domain.repository.CharacterRepository
import com.bacon.domain.repository.CharactersDetailRepository
import com.bacon.domain.repository.EpisodesRepository
import com.bacon.domain.repository.LocationRepository
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

    @Provides
    fun provideCharactersDetailRepository(characterDetailApiService: CharacterDetailApiService): CharactersDetailRepository {
        return CharactersDetailRepositoryImpl(characterDetailApiService)
    }
}

