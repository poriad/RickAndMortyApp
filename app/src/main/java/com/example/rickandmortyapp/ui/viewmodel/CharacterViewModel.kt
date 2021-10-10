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

class CharacterViewModel: ViewModel() {

    //var characterModel = MutableLiveData<Character>()
    var charactersModel = MutableLiveData<List<Character>>()

    //var getCharacterUseCase = GetCharacterUseCase()
    var getCharactersUseCase = GetCharactersUseCase()

    fun onCreate() {
        viewModelScope.launch {

           // var result = getCharacterUseCase()
            val result = getCharactersUseCase()

            if (result != null) {
                charactersModel.postValue(result.results)
            }
        }
    }

    fun onClick() {
        viewModelScope.launch {
            val result = getCharactersUseCase()

            if (result != null) {
                charactersModel.postValue(result.results)
            }
        }
    }

    companion object {
        var characterPage = 1
    }
}