package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.data.RickAndMortyRepository

class GetEpisodesSeasonFourUseCase {

    private val rickAndMortyRepository = RickAndMortyRepository()

    suspend operator fun invoke() = rickAndMortyRepository.getEpisodes("32,33,34,35,36,37,38,39,40,41")
}