package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.data.RickAndMortyRepository
import javax.inject.Inject

class GetEpisodesSeasonThreeUseCase @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
) {
    suspend operator fun invoke() = rickAndMortyRepository.getEpisodes("22,23,24,25,26,27,28,29,30,31")
}