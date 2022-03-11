package com.example.rickandmortyarchitecture.di

import com.bacon.data.remote.apiservices.CharacterApiService
import com.bacon.data.remote.apiservices.CharacterDetailApiService
import com.bacon.data.remote.apiservices.EpisodesApiService
import com.bacon.data.remote.apiservices.LocationApiService
import com.bacon.data.repository.*
import com.bacon.domain.repository.*
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

    @Provides
    fun provideEpisodeDetailRepository(episodesApiService: EpisodesApiService): EpisodesDetailRepository {
        return EpisodeDetailRepositoryImpl(episodesApiService)
    }
}

