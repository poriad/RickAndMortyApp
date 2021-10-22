package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.data.RickAndMortyRepository

class GetCharactersByEpisodeUseCase {

    private val rickAndMortyRepository = RickAndMortyRepository()

    suspend operator fun invoke(characters: String) =  rickAndMortyRepository.getCharactersByEpisode(characters)
}