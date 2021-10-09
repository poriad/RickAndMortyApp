package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.data.RickAndMortyRepository
import com.example.rickandmortyapp.data.model.Characters

class GetCharactersUseCase {

    private val rickAndMortyRepository = RickAndMortyRepository()

    suspend operator fun invoke(page: Int): Characters {
        return rickAndMortyRepository.getCharacters(page)
    }
}