package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.data.RickAndMortyRepository
import javax.inject.Inject

class GetCharactersByEpisodeUseCase @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
) {
    suspend operator fun invoke(characters: String) =  rickAndMortyRepository.getCharactersByEpisode(characters)
}