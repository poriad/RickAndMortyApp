package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.data.RickAndMortyRepository
import com.example.rickandmortyapp.data.model.Characters
import com.example.rickandmortyapp.ui.viewmodel.CharactersViewModel.Companion.characterPage

class GetCharactersUseCase {

    private val rickAndMortyRepository = RickAndMortyRepository()

    suspend operator fun invoke(): Characters {
        return rickAndMortyRepository.getCharacters(characterPage)
    }
}