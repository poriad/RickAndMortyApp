package com.example.rickandmortyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.domain.GetCharactersByEpisodeUseCase
import kotlinx.coroutines.launch

class EpisodeViewModel: ViewModel() {
    private var isLoading = MutableLiveData<Boolean>()
    var charactersByEpisode = MutableLiveData<List<Character>>()

    private var getCharactersByEpisodeUseCase = GetCharactersByEpisodeUseCase()

    fun onCreate(characters: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            var result = getCharactersByEpisodeUseCase(characters)
            if (result != null) {
                charactersByEpisode.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}