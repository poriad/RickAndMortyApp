package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.data.RickAndMortyRepository

class GetCharacterUseCase {

    private val rickAndMortyRepository = RickAndMortyRepository()

    suspend operator fun invoke(id: Int) = rickAndMortyRepository.getCharacter(id)
}