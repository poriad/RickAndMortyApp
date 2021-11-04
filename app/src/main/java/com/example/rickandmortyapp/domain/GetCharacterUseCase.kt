package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.data.RickAndMortyRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
) {

    suspend operator fun invoke(id: Int) = rickAndMortyRepository.getCharacter(id)
}