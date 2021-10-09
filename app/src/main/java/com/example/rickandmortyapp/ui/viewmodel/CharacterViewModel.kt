package com.example.rickandmortyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.model.Characters
import com.example.rickandmortyapp.domain.GetCharacterUseCase
import com.example.rickandmortyapp.domain.GetCharactersUseCase
import kotlinx.coroutines.launch

class CharacterViewModel: ViewModel() {

    //var characterModel = MutableLiveData<Character>()
    var charactersModel = MutableLiveData<List<Character>>()

    //var getCharacterUseCase = GetCharacterUseCase()
    var getCharactersUseCase = GetCharactersUseCase()
    var page: Int = 5

    fun onCreate() {
        viewModelScope.launch {

           // var result = getCharacterUseCase()
            var result = getCharactersUseCase(page)

            if (result != null) {
                //characterModel.postValue(result);
                charactersModel.postValue(result.results)
            }
        }
    }
}