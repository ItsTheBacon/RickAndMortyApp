package com.example.rickandmortyarchitecture.presentation.ui.fragments.characters

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bacon.data.remote.repository.CharacterRepository
import com.bacon.data.remote.repository.EpisodeDetailRepository
import com.example.rickandmortyarchitecture.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharacterRepository,
    private val repositoryEpisode: EpisodeDetailRepository,
) : BaseViewModel() {
    fun fetchCharacters() = repository.fetchCharacters().cachedIn(viewModelScope)

    fun fetchEpisode(id: Int) = repositoryEpisode.fetchEpisode(id).asLiveData()

}
