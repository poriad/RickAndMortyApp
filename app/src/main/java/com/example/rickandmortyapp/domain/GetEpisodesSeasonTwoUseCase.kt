package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.data.RickAndMortyRepository
import javax.inject.Inject

class GetEpisodesSeasonTwoUseCase @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
) {
    suspend operator fun invoke() = rickAndMortyRepository.getEpisodes("12,13,14,15,16,17,18,19,20,21")

}