package com.example.rickandmortyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.model.Characters
import com.example.rickandmortyapp.domain.GetCharacterUseCase
import com.example.rickandmortyapp.domain.GetCharactersUseCase
import com.example.rickandmortyapp.ui.view.MainActivity
import kotlinx.coroutines.launch

class CharactersViewModel: ViewModel() {

    //var characterModel = MutableLiveData<Character>()
    var charactersModel = MutableLiveData<List<Character>>()
    var characterModel = MutableLiveData<Character>()
    val isLoading = MutableLiveData<Boolean>()

    var getCharacterUseCase = GetCharacterUseCase()

    var getCharactersUseCase = GetCharactersUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
           // var result = getCharacterUseCase()
            val result = getCharactersUseCase()


            if (result != null || result.results.isEmpty()) {
                charactersModel.postValue(result.results)
                isLoading.postValue(false)
            }
        }
    }

    fun onClick() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCharactersUseCase()

            if (result != null) {
                charactersModel.postValue(result.results)
                isLoading.postValue(false)
            }
        }
    }


    // Refactor this
    fun onCreateCharacter(id: Int) {
        viewModelScope.launch {

            // var result = getCharacterUseCase()
            val result = getCharacterUseCase(id)
            isLoading.postValue(true)

            if (result != null) {
                characterModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    companion object {
        var characterPage = 1
    }
}