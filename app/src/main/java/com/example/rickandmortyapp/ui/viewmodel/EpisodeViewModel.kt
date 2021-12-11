package com.example.rickandmortyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.domain.GetCharactersByEpisodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val getCharactersByEpisodeUseCase: GetCharactersByEpisodeUseCase
): ViewModel() {
    private var isLoading = MutableLiveData<Boolean>()
    var charactersByEpisode = MutableLiveData<List<Character>>()

    fun onCreate(characters: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCharactersByEpisodeUseCase(characters)
            if (result != null) {
                charactersByEpisode.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}